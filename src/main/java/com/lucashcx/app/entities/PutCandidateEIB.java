package com.lucashcx.app.entities;

import java.util.Map;

import com.lucashcx.app.models.PutCandidateEIBRow;

public class PutCandidateEIB implements EIBable{
    public static final int headerRowNumber = 4;
    public static final int rowQuantity = 1;
    public static final String variableARGB = "FFFFFF00";
    public static final String fixedARGB = "FF70AD47";
    public static final String inputfilePath = "Put_Candidate.xlsx";
    public static final String outputfilePath = "output - " + inputfilePath;

    public Map<String, Object> getEIBRow() {
        return (new PutCandidateEIBRow()).getFakeValues();
    }

    public void run() {
        EIB.populateEIB(this);
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

    public String getFixedARGB(){
        return fixedARGB;
    }

    public String getInputfilePath() {
        return inputfilePath;
    }

    public String getOutputfilePath() {
        return outputfilePath;
    }    
}
