package com.company;

public class IncorrectDenominator extends Exception {
    public IncorrectDenominator(String errorMessage)
    {
        super(errorMessage);
    }
}
