package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String requestOperation() {
        return validate(scanner.nextLine());
    }

    public static String validate (String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(String.format("입력값을 입력해주세요."));
        }
        return input;
    }
}
