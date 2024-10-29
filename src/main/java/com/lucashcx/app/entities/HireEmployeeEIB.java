package com.lucashcx.app.entities;

import java.util.Map;
import java.util.Optional;

import com.lucashcx.app.models.HireEmployeeEIBRow;

public class HireEmployeeEIB implements EIBable {
  public static final String sheetName = "Hire Employee";
  public static final int headerRowNumber = 4;
  public static final int rowQuantity = 1;
  public static final String variableARGB = "FFFFFF00";
  public static final String fixedARGB = "FF70AD47";
  public static final String inputfilePath = "Hire_Employee.xlsx";
  public static final String outputfilePath = "output - " + inputfilePath;

  public Map<String, Object> getEIBRow() {
    return (new HireEmployeeEIBRow()).getFakeValues();
  }

  public void run() {
    EIB.populateEIB(this);
  }

  public Optional<String> getSheetName() {
    return Optional.of(sheetName);
  }

  public int getHeaderRowNumber() {
    return headerRowNumber;
  }

  public int getRowQuantity() {
    return rowQuantity;
  }

  public String getVariableARGB() {
    return variableARGB;
  }

  public String getFixedARGB() {
    return fixedARGB;
  }

  public String getInputfilePath() {
    return inputfilePath;
  }

  public String getOutputfilePath() {
    return outputfilePath;
  }
}