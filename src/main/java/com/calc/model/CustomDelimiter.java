package com.calc.model;

import com.calc.constant.StringAddCalculatorConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter {

    private Matcher matcher;

    public boolean hasCustomDelimiter(String inputValue) {
        matcher = Pattern.compile("//(.)\n(.*)").matcher(inputValue);
        return matcher.find();
    }

    public String[] getValuesToAdd(String inputValue) {
        if (hasCustomDelimiter(inputValue)) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return new String[StringAddCalculatorConstant.ZERO_NUMBER];
    }
}
