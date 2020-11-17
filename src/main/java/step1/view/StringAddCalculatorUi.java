package step1.view;

import java.util.Scanner;

public class StringAddCalculatorUi {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputExpression() {
        System.out.println("계산 할 값을 입력하세요.");
        String expression = scanner.next();
        close();
        return expression;
    }

    public static void resultPrint(int sum) {
        System.out.println(sum);
    }

    public static void close() {
        scanner.close();
    }
}
