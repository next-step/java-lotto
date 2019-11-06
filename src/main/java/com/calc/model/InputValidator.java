package com.calc.model;

public class InputValidator {


    private static final String INVALID_MESSAGE = "숫자가 아니거나 음수입니다.";
    private static final String STRING_ZERO_NUMBER = "0";
    private static final String EMPTY_STRING = "";

    public String isNull(String inputValue) {
        if (inputValue == null) {
            return STRING_ZERO_NUMBER;
        }

        return inputValue;
    }

    public String isEmpty(String inputValue) {
        if (EMPTY_STRING.equals(inputValue)) {
            return STRING_ZERO_NUMBER;
        }

        return inputValue;
    }

    public String validate(String invalidValue) {
        int result = isStringNumber(invalidValue);

        if (result < 0) {
            throw new RuntimeException(INVALID_MESSAGE);
        }

        return String.valueOf(result);
    }

    private int isStringNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new RuntimeException(INVALID_MESSAGE);
        }
    }

}
