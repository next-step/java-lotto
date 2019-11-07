package com.lotto.model;

import com.lotto.constant.StringAddCalculatorConstant;

public class StringAddCalculator {

    private StringAddCalcInputValidator stringAddCalcInputValidator = new StringAddCalcInputValidator();
    private StringAddCalcCustomDelimiter stringAddCalcCustomDelimiter = new StringAddCalcCustomDelimiter();

    public int execute(String inputValue) {
        inputValue = stringAddCalcInputValidator.validateNullAndEmpty(inputValue);
        if (StringAddCalculatorConstant.STRING_ZERO_NUMBER.equals(inputValue)) {
            return StringAddCalculatorConstant.ZERO_NUMBER;
        }

        String[] inputValues = stringAddCalcCustomDelimiter.getValuesToAdd(inputValue);

        return add(inputValues);
     }

     private int add(String[] inputValues) {
        int result = StringAddCalculatorConstant.ZERO_NUMBER;
        for (String stringNumber : inputValues) {
            result += stringAddCalcInputValidator.validateStringNumber(stringNumber);
        }
        return result;
     }
}
