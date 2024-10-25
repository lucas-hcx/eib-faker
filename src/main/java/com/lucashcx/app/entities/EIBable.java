package com.lucashcx.app.entities;

import java.util.Map;
import java.util.Optional;

public interface EIBable {
    public Optional<String> getSheetName();

    public int getHeaderRowNumber();

    public int getRowQuantity();

    public String getVariableARGB();

    public String getFixedARGB();

    public String getInputfilePath();

    public String getOutputfilePath();

    public Map<String, Object> getEIBRow();

    public void run();
}
