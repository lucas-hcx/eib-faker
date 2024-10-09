package com.lucashcx.app.entities;

import java.util.Map;

public interface EIBable {
    public int getHeaderRowNumber();

    public int getRowQuantity();

    public String getVariableARGB();

    public String getFixedARGB();

    public String getInputfilePath();

    public String getOutputfilePath();

    public Map<String, Object> getEIBRow();

    public void run();
}
