package com.hskim.lotto.ui;

import com.hskim.lotto.model.UserInput;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
