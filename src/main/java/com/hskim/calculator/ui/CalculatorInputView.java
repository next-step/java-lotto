package com.hskim.calculator.ui;

import com.hskim.calculator.model.UserInput;

import java.util.*;

public class CalculatorInputView {

    private static final String INPUT_MESSAGE = "수식을 입력해주세요 : ";
    private static final Scanner scanner = new Scanner(System.in);

    public void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public UserInput getUserInput() {
        return new UserInput(scanner.nextLine());
    }
}
