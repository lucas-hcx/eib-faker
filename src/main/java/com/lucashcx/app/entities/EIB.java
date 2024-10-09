package com.lucashcx.app.entities;

import java.util.Iterator;
import java.util.Optional;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.lucashcx.app.services.SpreadSheet;

public class EIB {
    public static void populateEIB(EIBable eib) {
        int headerRowNumber = eib.getHeaderRowNumber();
        int rowQuantity = eib.getRowQuantity();
        String variableARGB = eib.getVariableARGB();
        String fixedARGB = eib.getFixedARGB();
        String inputfilePath = eib.getInputfilePath();
        String outputfilePath = eib.getOutputfilePath();

        Sheet sheet = SpreadSheet.openSingleWorkbookFile(inputfilePath).get();
        Row headers = SpreadSheet.getRow(sheet, headerRowNumber);
        Row firstRow = SpreadSheet.getRow(sheet, headerRowNumber + 1);
        int lastRowNumber = headerRowNumber + rowQuantity + 1;

        for (int i = headerRowNumber + 2; i <= lastRowNumber; i++) {
            Iterator<Cell> firstRowIterator = firstRow.cellIterator();
            Row row = SpreadSheet.createRow(sheet, i);
            Map<String, Object> fakeValues = eib.getEIBRow();
            while (firstRowIterator.hasNext()) {
                Cell firstRowCell = firstRowIterator.next();
                int columnIndex = firstRowCell.getColumnIndex();
                Optional<String> firstRowCellColor = SpreadSheet.getCellColorARGBHex(firstRowCell);
                Cell headerCell = headers.getCell(columnIndex);
                if (firstRowCellColor.isPresent() && firstRowCellColor.get().equals(variableARGB)) {
                    Cell cell = SpreadSheet.createCellOnRow(row, columnIndex);
                    SpreadSheet.setCell(cell, fakeValues.get(headerCell.getStringCellValue()));
                }
                if (firstRowCellColor.isPresent() && firstRowCellColor.get().equals(fixedARGB)) {
                    Cell cell = SpreadSheet.createCellOnRow(row, columnIndex);
                    SpreadSheet.copyCellContentAsString(firstRowCell, cell);
                }
            }
        }

        SpreadSheet.excludeRow(sheet, firstRow);

        SpreadSheet.saveFile(sheet, outputfilePath);
        SpreadSheet.closeWorkbook(sheet);
    }
}
