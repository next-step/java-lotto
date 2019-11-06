package com.calc.model;

import com.calc.constant.StringAddCalculatorConstant;

public class StringAddCalculator {

    public int add(String inputValue) {
        InputValidator inputValidator = new InputValidator();
        inputValue = inputValidator.validateNullAndEmpty(inputValue);

        if (StringAddCalculatorConstant.STRING_ZERO_NUMBER.equals(inputValue)) {
            return StringAddCalculatorConstant.ZERO_NUMBER;
        }

        String[] inputValues = inputValue.split(",|:");
        int result = StringAddCalculatorConstant.ZERO_NUMBER;
        for (String stringNumber : inputValues) {
            result += inputValidator.validateStringNumber(stringNumber);
        }

        return result;
    }
}
