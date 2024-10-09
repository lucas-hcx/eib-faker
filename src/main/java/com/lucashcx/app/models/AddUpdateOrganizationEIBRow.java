package com.lucashcx.app.models;

import java.util.HashMap;
import java.util.Map;

import com.lucashcx.app.services.WorkdayFaker;

public class AddUpdateOrganizationEIBRow implements Fakeable {
    static Long spreadSheetKey = 0L;
    private Map<String, Object> fakeValues = new HashMap<>();

    public AddUpdateOrganizationEIBRow() {
        spreadSheetKey++;
        fakeValues.put("Spreadsheet Key*", String.valueOf(spreadSheetKey));
        fakeValues.put("Organization Reference ID", WorkdayFaker.getOrganizationID());
        fakeValues.put("Organization Name", WorkdayFaker.getOrganizationName());
    }

    public Map<String, Object> getFakeValues() {
        return fakeValues;
    }
}
