package common.view;

import java.util.Scanner;

public class CalculatorInputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String requestOperation() {
        System.out.println("수식을 입력하세요.");
        return validate(scanner.nextLine());
    }

    public static String validate (String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값을 입력해주세요.");
        }
        return input;
    }
}
