package com.lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalcCustomDelimiter {

    private final String BASE_DELIMITER = ",|;";
    private final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    private Matcher matcher;

    public String[] getValuesToAdd(String inputValue) {
        if (hasCustomDelimiter(inputValue)) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return inputValue.split(BASE_DELIMITER);
    }

    public boolean hasCustomDelimiter(String inputValue) {
        matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(inputValue);
        return matcher.find();
    }


}
