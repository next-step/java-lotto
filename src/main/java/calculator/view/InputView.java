package calculator.view;

import java.util.Scanner;

public class InputView {

    public static final String INPUT_START_MESSAGE = "계산할 식을 입력하세요.";
    public static final String SPACE_SEPARATOR = " ";
    public static final String EXCEPTION_MESSAGE = "입력값이 존재해야 합니다.";

    private InputView() {
    }

    public static String[] getInput() {
        System.out.println(INPUT_START_MESSAGE);
        try(Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            validateInput(input);
            return input.split(SPACE_SEPARATOR);
        }
    }

    private static void validateInput(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
