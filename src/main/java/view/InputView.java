package view;

import java.util.Scanner;

import static calculator.Calculator.calculate;

public class InputView {

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("사칙 연산을 수행할 문자열을 입력하세요: ");

        calculate(parseInput(scanner.nextLine()));
    }

    public static String[] parseInput(String input) {
        validate(input);
        return input.split(" ");
    }

    private static void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자일 수 없습니다.");
        }
    }
}
