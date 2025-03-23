package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String read(String question) {
        System.out.println(question);
        String input = scanner.nextLine();
        try {
            validate(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return read(question);
        }
    }

    private static void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
    }
}
