package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getExpression() {
        System.out.println("계산식을 입력하시오.");
        return scanner.nextLine();
    }
}
