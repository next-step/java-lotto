package com.calc.model;

import com.lotto.constant.StringAddCalculatorConstant;

public class StringAddCalcInputValidator {


    private static final String INVALID_NUMBER_MESSAGE = "숫자가 아닙니다.";
    private static final String NEGATIVE_NUMBER_MESSAGE = "입력 된 값이 음수입니다.";
    private static final String EMPTY_STRING = "";

    public String validateNullAndEmpty(String inputValue) {
        if (isNull(inputValue)) {
            return StringAddCalculatorConstant.STRING_ZERO_NUMBER;
        }

        if (isEmpty(inputValue)) {
            return StringAddCalculatorConstant.STRING_ZERO_NUMBER;
        }

        return inputValue;
    }

    private boolean isNull(String inputValue) {
        if (inputValue == null) {
            return true;
        }

        return false;
    }

    private boolean isEmpty(String inputValue) {
        if (EMPTY_STRING.equals(inputValue)) {
            return true;
        }

        return false;
    }

    private int isStringNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new RuntimeException(INVALID_NUMBER_MESSAGE);
        }
    }

    public int validateStringNumber(String stringNumber) {
        int result = isStringNumber(stringNumber);

        if (StringAddCalculatorConstant.ZERO_NUMBER > result) {
            throw new RuntimeException(NEGATIVE_NUMBER_MESSAGE);
        }

        return result;
    }
}
