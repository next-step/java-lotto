package com.jaenyeong.mission01.calculator;

public class Output {
    private static final String TEXT_INPUT_EXPRESSION = "덧셈 연산을 처리할 수식을 입력하세요.";

    public static void printTextExpression() {
        System.out.println(TEXT_INPUT_EXPRESSION);
    }

    public static void printResultNumber(final int result) {
        System.out.println(result);
    }
}
