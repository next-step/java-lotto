package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String QUESTION = "사칙연산 식을 입력해주세요.";

    public static String inputExpression() {
        System.out.println(QUESTION);
        return scanner.nextLine();
    }
}
