package calculator.ui;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static String inputString() {
        System.out.println("사칙연산 문자열을 입력해 주세요. 예) 2 + 3 * 4 / 2 ");
        String inputString = String.valueOf(scanner.nextLine());
        validateInput(inputString);
        return inputString;
    }

    private static void validateInput(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 이거나 공백 문자 입니다.");
        }
    }
}
