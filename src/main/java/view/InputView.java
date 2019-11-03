package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String EMPTY = "";
    private static final String DEFAULT = "0";

    public static String input() {
        System.out.println("계산 식을 입력해 주세요.");
        return getInput(scanner.nextLine());
    }

    private static String getInput(String input) {
        if (input == null || input.trim().matches(EMPTY)) {
            return DEFAULT;
        }
        return input;
    }
}
