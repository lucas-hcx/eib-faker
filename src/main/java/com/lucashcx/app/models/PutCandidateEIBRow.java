package com.lucashcx.app.models;

import java.util.HashMap;
import java.util.Map;

import com.lucashcx.app.services.WorkdayFaker;

public class PutCandidateEIBRow {
    static int spreadSheetKey = 0;
    private Map<String, String> fakeValues = new HashMap<>();

    public PutCandidateEIBRow() {
        spreadSheetKey++;
        fakeValues.put("Spreadsheet Key*",  String.valueOf(spreadSheetKey));
        fakeValues.put("First Name", WorkdayFaker.getFirstName());
        fakeValues.put("Last Name", WorkdayFaker.getLastName());
        fakeValues.put("Phone Number", WorkdayFaker.getPhoneNumber());
        fakeValues.put("Email Address", WorkdayFaker.getEmailAddress());
        fakeValues.put("Address Line 1", WorkdayFaker.getAddressLine1());
        fakeValues.put("Address Line 2", WorkdayFaker.getAddressLine2());
        fakeValues.put("City", WorkdayFaker.getCity());
        fakeValues.put("City Subdivision 1", WorkdayFaker.getCity());
        fakeValues.put("Country Region", WorkdayFaker.getCountryRegion());
        fakeValues.put("Postal Code", WorkdayFaker.getPostalCode());
        fakeValues.put("Gender", WorkdayFaker.getGender());
        fakeValues.put("Date of Birth", WorkdayFaker.getDateOfBirth());
        fakeValues.put("City of Birth", WorkdayFaker.getCity());
        fakeValues.put("ID", WorkdayFaker.getID());
    }

    public Map<String, String> getFakeValues() {
        return fakeValues;
    }

}
