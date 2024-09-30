package com.lucashcx.app.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreadSheet {

    public static Sheet createSheet(String sheetName) {
        Workbook workbook = new XSSFWorkbook();
        return workbook.createSheet(sheetName);
    }

    public static Row createRow(Sheet sheet, int index) {
        return sheet.createRow(index);
    }

    public static Cell createCellOnRow(Row row, int index) {
        return row.createCell(index);
    }

    public static void setStringCell(Cell cell, String content) {
        cell.setCellValue(content);
    }

    public static void setNumericCell(Cell cell, double content) {
        cell.setCellValue(content);
    }

    public static void setCellsOnRow(Row row, List<String> contents) {
        for (int i = 0; i < contents.size(); i++) {
            Cell cell = createCellOnRow(row, i);
            setStringCell(cell, contents.get(i));
        }
    }

    public static Optional<Cell> findCellOnRowByContent(Row row, String content) {
        Iterator<Cell> cellIterator = row.cellIterator();
        Optional<Cell> searchedCell = Optional.empty();

        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(content)) {
                searchedCell = Optional.of(cell);
                break;
            }
        }

        return searchedCell;
    }

    public static void setCellOnRowByHeaderName(Row row, String headerString, int headerRowIndex, String content) {
        Sheet sheet = row.getSheet();
        Row headers = sheet.getRow(headerRowIndex);
        Optional<Cell> headerCell = findCellOnRowByContent(headers, headerString);
        Optional<Integer> cellColumnNumber = headerCell.isPresent() ? Optional.of(headerCell.get().getColumnIndex())
                : Optional.empty();

        if (cellColumnNumber.isPresent()) {
            Cell cellToSet = createCellOnRow(row, cellColumnNumber.get());
            setStringCell(cellToSet, content);
        }
    }

    public static void saveFile(Sheet sheet, String fileName) {
        Workbook workbook = sheet.getWorkbook();
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeWorkbook(Sheet sheet) {
        Workbook workbook = sheet.getWorkbook();
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Optional<Sheet> openSingleWorkbookFile(String filePath) {
        Optional<Sheet> sheet = Optional.empty();
        try (FileInputStream fileIn = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(fileIn);
            sheet = Optional.of(workbook.getSheetAt(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sheet;
    }

    public static Row getRow(Sheet sheet, int index) {
        return sheet.getRow(index);
    }

    public static Cell getCellByAddress(Sheet sheet, String reference) {
        CellReference cellReference = new CellReference(reference);
        Row row = sheet.getRow(cellReference.getRow());
        return row.getCell(cellReference.getCol());
    }

    public static Cell getCellByAddress(Sheet sheet, int rowNumber, int columnNumber) {
        Row row = sheet.getRow(rowNumber);
        return row.getCell(columnNumber);
    }

    public static Optional<String> getCellColorARGBHex(Cell cell) {
        Optional<XSSFColor> color = Optional.ofNullable((XSSFColor) cell.getCellStyle().getFillForegroundColorColor());
        return color.isPresent() ? Optional.of(color.get().getARGBHex()) : Optional.empty();
    }

    public static void copyCellContent(Cell source, Cell target) {
        switch (source.getCellType()) {
            case STRING:
                target.setCellValue(source.getStringCellValue());
                break;
            case NUMERIC:
                target.setCellValue(source.getNumericCellValue());
                break;
            case BOOLEAN:
                target.setCellValue(source.getBooleanCellValue());
                break;
            case FORMULA:
                target.setCellFormula(source.getCellFormula());
                break;
            case BLANK:
                target.setCellType(CellType.BLANK);
                break;
            default:
                System.out.println("Tipo de célula não suportado.");
        }
    }

}