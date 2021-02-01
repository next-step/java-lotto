package calculator.string.view;

import java.util.Scanner;

public class Input {
    public static String expressionInput() {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();

        return expression;
    }
}
