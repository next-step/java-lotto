package utils;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputExpression() {
        String input = scanner.nextLine();
        isNullOrBlank(input);
        return input;
    }

    private static void isNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어 있거나 null입니다.");
        }
    }

    public static int toInt(String number) {
        return Integer.parseInt(number);
    }

    public static List<String> parse(String input) {
        return List.of(input.split(" "));
    }
}
