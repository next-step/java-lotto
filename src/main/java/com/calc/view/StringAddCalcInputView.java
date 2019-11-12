package com.calc.view;

import com.calc.model.StringAddCalcInputValidator;

import java.util.Scanner;

public class StringAddCalcInputView {

    private final String inputValue;

    private StringAddCalcInputValidator stringAddCalcInputValidator = new StringAddCalcInputValidator();

    public StringAddCalcInputView() {
        Scanner scanner = new Scanner(System.in);
        this.inputValue = scanner.next();
    }

    public String getInputValue() {
        return inputValue;
    }
}
