package calculator.view;

import calculator.exception.BlankExpressionException;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_MESSAGE = "문자열을 입력해주세요.(ex. 1+2/3)";

    private final Scanner scanner = new Scanner(System.in);

    public String readExpression() {
        System.out.println(INPUT_MESSAGE);
        String readExpression = scanner.nextLine();

        if (readExpression.isEmpty()) {
            throw new BlankExpressionException();
        }

        return readExpression.replace(" ", "");
    }

}
