package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final String MATHEMATICAL_EXPRESSION_INPUT_GUID_MESSAGE = "수식을 입력하세요.";

    public static String enteredMathematicalExpression() {
        System.out.println(MATHEMATICAL_EXPRESSION_INPUT_GUID_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
