package com.jaenyeong.mission01.calculator;

import java.util.Scanner;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String TEXT_INPUT_EXPRESSION = "덧셈 연산을 처리할 수식을 입력하세요.";

    private UI() {
    }

    public static String inputExpression() {
        System.out.println(TEXT_INPUT_EXPRESSION);
        return scanner.nextLine();
    }

    public static void printResultNumber(final int result) {
        System.out.println(result);
    }
}
