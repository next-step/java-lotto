package me.namuhuchutong.stringcalculator;

import java.util.Scanner;

public class Prompt {

    private static final String NUMBER_AND_OPERATORS_REGEX = "[0-9/*\\-+\\s]";

    private final Scanner scanner = new Scanner(System.in);

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String showStringPrompt(String message) {
        printMessage(message);
        String input = scanner.nextLine();
        validateBlank(input);
        validateCorrectExpression(input);
        return input.replaceAll(" ", "");
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("계산식은 공백일 수 없습니다.");
        }
    }

    private void validateCorrectExpression(String input) {
        String[] split = input.split(NUMBER_AND_OPERATORS_REGEX);
        if (split.length != 0) {
            throw new IllegalArgumentException("사칙연산자와 숫자만 입력할 수 있습니다.");
        }
    }

    public void printResult(int result) {
        System.out.println(result);
    }
}
