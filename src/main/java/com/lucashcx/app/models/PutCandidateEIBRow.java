package com.lucashcx.app.models;

import java.util.HashMap;
import java.util.Map;

import com.lucashcx.app.services.WorkdayFaker;

public class PutCandidateEIBRow implements Fakeable {
    static Long spreadSheetKey = 0L;
    private Map<String, Object> fakeValues = new HashMap<>();

    public PutCandidateEIBRow() {
        spreadSheetKey++;
        fakeValues.put("Spreadsheet Key*", String.valueOf(spreadSheetKey));
        fakeValues.put("First Name", WorkdayFaker.getFirstName().toUpperCase());
        fakeValues.put("Last Name", WorkdayFaker.getLastName().toUpperCase());
        fakeValues.put("Phone Number", WorkdayFaker.getPhoneNumber());
        fakeValues.put("Email Address", WorkdayFaker.getUnique("getEmailAddress"));
        fakeValues.put("Address Line 1", WorkdayFaker.getAddressLine1());
        fakeValues.put("Address Line 2", WorkdayFaker.getAddressLine2());
        fakeValues.put("City", WorkdayFaker.getCity().toUpperCase());
        fakeValues.put("City Subdivision 1", fakeValues.get("City"));
        fakeValues.put("Country Region", "BRA-SP");
        fakeValues.put("Postal Code", WorkdayFaker.getPostalCode());
        fakeValues.put("Gender", WorkdayFaker.getGender());
        fakeValues.put("Date of Birth", WorkdayFaker.getDateOfBirth());
        fakeValues.put("Birth Region", fakeValues.get("Country Region"));
        fakeValues.put("City of Birth", WorkdayFaker.getCity().toUpperCase());
        fakeValues.put("ID", WorkdayFaker.getUnique("getID"));
    }

    public Map<String, Object> getFakeValues() {
        return fakeValues;
    }

}
