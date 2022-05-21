package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String INSTANCE_ERROR_MESSAGE = "InputView 클래스를 인스턴스화 할수 없습니다";
    private static final String EXPRESSIONS_INPUT_MESSAGE = "수식을 입력하세요.";

    private InputView() {
        throw new AssertionError(INSTANCE_ERROR_MESSAGE);
    }

    public static String getExpressions() {
        System.out.println(EXPRESSIONS_INPUT_MESSAGE);

        return scanner.nextLine();
    }
}
