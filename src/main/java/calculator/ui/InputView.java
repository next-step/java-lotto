package calculator.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static String get() {
        System.out.println("식을 입력하세요.");
        String s = SCANNER.nextLine();
        validate(s);
        return s;
    }

    private static void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
}
