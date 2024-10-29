package com.lucashcx.app.models;

import java.util.HashMap;
import java.util.Map;

import com.lucashcx.app.services.WorkdayFaker;

public class ChangeJobEIBRow implements Fakeable {
  static Long spreadSheetKey = 0L;
  private Map<String, Object> fakeValues = new HashMap<>();

  public ChangeJobEIBRow() {
    spreadSheetKey++;
    fakeValues.put("Spreadsheet Key*", String.valueOf(spreadSheetKey));
    fakeValues.put("Position Title", WorkdayFaker.getJobName());
  }

  public Map<String, Object> getFakeValues() {
    return fakeValues;
  }
}
