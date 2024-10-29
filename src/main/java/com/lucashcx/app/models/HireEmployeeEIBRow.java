package com.lucashcx.app.models;

import java.util.HashMap;
import java.util.Map;

import com.lucashcx.app.services.WorkdayFaker;

public class HireEmployeeEIBRow implements Fakeable {
  static Long spreadSheetKey = 0L;
  private Map<String, Object> fakeValues = new HashMap<>();

  public HireEmployeeEIBRow() {
    spreadSheetKey++;
    fakeValues.put("Spreadsheet Key*", String.valueOf(spreadSheetKey));
  }

  public Map<String, Object> getFakeValues() {
    return fakeValues;
  }
}
