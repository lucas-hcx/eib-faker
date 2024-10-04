package com.lucashcx.app.entities;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.lucashcx.app.models.PutCandidateEIBRow;
import com.lucashcx.app.services.SpreadSheet;

public class PutCandidateEIB {
    static final int headerRowNumber = 4;
    static final int rowQuantity = 10000;
    static final String variableARGB = "FFFFFF00";
    static final String fixedARGB = "FF70AD47";
    static final List<String> headersNames = List.of(
        "Spreadsheet Key*",
        "Add Only",
        "First Name",
        "Last Name",
        "Phone Device Type",
        "Country Phone Code",
        "Phone Number",
        "Email Address",
        "Country",
        "Address Line 1",
        "Address Line 2",
        "City",
        "City Subdivision 1",
        "Country Region",
        "Postal Code",
        "Do Not Hire",
        "Withdrawn",
        "Row ID*",
        "Row ID**",
        "Stage*",
        "Gender",
        "Date of Birth",
        "Birth Country",
        "Birth Region",
        "City of Birth",
        "Ethnicity+",
        "Nationality",
        "Questionnaire*",
        "Row ID**",
        "Question Order*",
        "Row ID*",
        "ID",
        "ID Type",
        "Country"
    );

    
    public static void run() {
        Sheet sheet = SpreadSheet.openSingleWorkbookFile("put candidate - RPA.xlsx").get();
        Row headers = SpreadSheet.getRow(sheet, headerRowNumber);
        Row firstRow = SpreadSheet.getRow(sheet, headerRowNumber + 1);
        int lastRowNumber = headerRowNumber + rowQuantity + 1;

        for(int i = headerRowNumber + 2; i <= lastRowNumber; i++) {
            Iterator<Cell> firstRowIterator = firstRow.cellIterator();
            Row row = SpreadSheet.createRow(sheet, i);
            Map<String, Object> fakeValues = (new PutCandidateEIBRow()).getFakeValues();
            while(firstRowIterator.hasNext()) {
                Cell firstRowCell = firstRowIterator.next();
                int columnIndex = firstRowCell.getColumnIndex();
                Optional<String> firstRowCellColor = SpreadSheet.getCellColorARGBHex(firstRowCell);
                Cell headerCell = headers.getCell(columnIndex);
                if(firstRowCellColor.isPresent() && firstRowCellColor.get().equals(variableARGB)) {
                    Cell cell = SpreadSheet.createCellOnRow(row, columnIndex);
                    SpreadSheet.setCell(cell, fakeValues.get(headerCell.getStringCellValue()));
                }
                if(firstRowCellColor.isPresent() && firstRowCellColor.get().equals(fixedARGB)) {
                    Cell cell = SpreadSheet.createCellOnRow(row, columnIndex);
                    SpreadSheet.copyCellContentAsString(firstRowCell, cell);
                }
            }
        }

        SpreadSheet.excludeRow(sheet, firstRow);

        SpreadSheet.saveFile(sheet, "teste.xlsx");
        SpreadSheet.closeWorkbook(sheet);
    }
}
