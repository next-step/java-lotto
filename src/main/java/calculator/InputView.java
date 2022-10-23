package calculator;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MESSAGE = "Input: ";

    private InputView() {

    }

    public static String readExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(INPUT_MESSAGE);
        return scanner.nextLine().trim();
    }
}
