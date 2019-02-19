package com.qa.helpers;

public class Parameters {

	private String types;

    public String getTypes ()
    {
        return types;
    }

    public void setTypes (String types)
    {
        this.types = types;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [types = "+types+"]";
    }
}
