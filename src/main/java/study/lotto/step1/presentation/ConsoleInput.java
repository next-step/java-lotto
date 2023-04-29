package study.lotto.step1.presentation;

import java.util.Scanner;

public class ConsoleInput {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String EXPRESSION_INPUT_MESSAGE = "수식 입력: ";

    private ConsoleInput() {
    }

    public static String expressionFromConsole() {
        System.out.print(EXPRESSION_INPUT_MESSAGE);
        return SCANNER.nextLine();
    }
}
