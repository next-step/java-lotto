package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readInput() {
        String input = scanner.nextLine().trim();
        validateEmpty(input);
        return input;
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("문자열은 빈 값일 수 없습니다");
        }
    }
}
