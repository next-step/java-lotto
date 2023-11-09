package me.namuhuchutong.stringcalculator;

import java.util.Scanner;

public class Prompt {

    private final Scanner scanner = new Scanner(System.in);

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String showStringPrompt(String message) {
        printMessage(message);
        String input = scanner.nextLine();
        validateBlank(input);
        return input.replaceAll(" ", "");
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("계산식은 공백일 수 없습니다.");
        }
    }

    public void printResult(int result) {
        System.out.println(result);
    }
}
