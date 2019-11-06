package com.calc.view;

import com.calc.model.InputValidator;

import java.util.Scanner;

public class InputView {

    private final String inputValue;

    private InputValidator inputValidator = new InputValidator();

    public InputView() {
        Scanner scanner = new Scanner(System.in);
        this.inputValue = scanner.next();
    }

    public String getInputValue() {
        return inputValue;
    }
}
