package step1.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = " ";

    private InputView() {
    }

    public static String input() {
        System.out.println("계산식을 입력하세요");
        String stringExpression = scanner.nextLine().trim();
        if (!stringExpression.contains(SEPARATOR)) {
            throw new IllegalArgumentException("구분자는 \" \" 여야 합니다");
        }
        return stringExpression;
    }
}
