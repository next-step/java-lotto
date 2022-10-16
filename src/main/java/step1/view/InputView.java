package step1.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static String getExpression() {
        System.out.println("사칙연산을 수행할 문자열을 입력해주세요.");
        return SCANNER.nextLine();
    }
}
