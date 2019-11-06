package com.calc.model;

import com.calc.constant.StringAddCalculatorConstant;

public class StringAddCalculator {

    private InputValidator inputValidator = new InputValidator();
    private CustomDelimiter customDelimiter = new CustomDelimiter();

    public int execute(String inputValue) {
        inputValue = inputValidator.validateNullAndEmpty(inputValue);
        if (StringAddCalculatorConstant.STRING_ZERO_NUMBER.equals(inputValue)) {
            return StringAddCalculatorConstant.ZERO_NUMBER;
        }

        String[] inputValues = customDelimiter.getValuesToAdd(inputValue);
        if (inputValue.length() == StringAddCalculatorConstant.ZERO_NUMBER) {
            inputValues = inputValue.split(",|:");
        }

        return add(inputValues);
     }

     private int add(String[] inputValues) {
        int result = StringAddCalculatorConstant.ZERO_NUMBER;
        for (String stringNumber : inputValues) {
            result += inputValidator.validateStringNumber(stringNumber);
        }
        return result;
     }
}
