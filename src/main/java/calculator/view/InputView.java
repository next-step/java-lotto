package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ERROR_EMPTY_INPUT = "문자열은 빈 값일 수 없습니다";

    public static String readInput() {
        String input = SCANNER.nextLine().trim();
        validateEmpty(input);
        return input;
    }
    
    private static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }
}