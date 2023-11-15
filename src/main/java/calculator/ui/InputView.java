package calculator.ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputExpression() {
        System.out.println("수행할 사칙연산식을 입력하세요.");
        return sc.nextLine();
    }
}
