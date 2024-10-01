package com.lucashcx.app.models;

import java.util.HashMap;
import java.util.Map;

import com.lucashcx.app.services.WorkdayFaker;

public class PutCandidateEIBRow {
    static Long spreadSheetKey = 1L;
    private Map<String, Object> fakeValues = new HashMap<>();

    public PutCandidateEIBRow() {
        spreadSheetKey++;
        fakeValues.put("Spreadsheet Key*", String.valueOf(spreadSheetKey));
        fakeValues.put("First Name", WorkdayFaker.getFirstName().toUpperCase());
        fakeValues.put("Last Name", WorkdayFaker.getLastName().toUpperCase());
        fakeValues.put("Phone Number", WorkdayFaker.getPhoneNumber());
        fakeValues.put("Email Address", WorkdayFaker.getEmailAddress());
        fakeValues.put("Address Line 1", WorkdayFaker.getAddressLine1());
        fakeValues.put("Address Line 2", WorkdayFaker.getAddressLine2());
        fakeValues.put("City", WorkdayFaker.getCity().toUpperCase());
        fakeValues.put("City Subdivision 1", fakeValues.get("City"));
        fakeValues.put("Country Region", WorkdayFaker.getCountryRegion());
        fakeValues.put("Postal Code", WorkdayFaker.getPostalCode());
        fakeValues.put("Gender", WorkdayFaker.getGender());
        fakeValues.put("Date of Birth", WorkdayFaker.getDateOfBirth());
        fakeValues.put("City of Birth", WorkdayFaker.getCity().toUpperCase());
        fakeValues.put("ID", WorkdayFaker.getID());
    }

    public Map<String, Object> getFakeValues() {
        return fakeValues;
    }

}
