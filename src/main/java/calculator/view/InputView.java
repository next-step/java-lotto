package calculator.view;

import java.util.Scanner;

public class InputView {

    public static String[] inputText() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("사칙 연산을 수행할 문자열을 입력하세요: ");

        return parseInput(scanner.nextLine());
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
