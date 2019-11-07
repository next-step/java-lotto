package com.lotto.view;

import com.lotto.model.StringAddCalcInputValidator;

import java.util.Scanner;

public class StringAddCalculatorInputView {

    private final String inputValue;

    private StringAddCalcInputValidator stringAddCalcInputValidator = new StringAddCalcInputValidator();

    public StringAddCalculatorInputView() {
        Scanner scanner = new Scanner(System.in);
        this.inputValue = scanner.next();
    }

    public String getInputValue() {
        return inputValue;
    }
}
