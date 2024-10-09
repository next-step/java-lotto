package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static String getExpression() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        String expression = SCANNER.nextLine();
        if (expression == null) {
            return "";
        }
        return expression;
    }
}
