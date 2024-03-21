package calculator.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readExpression() {
        System.out.print("수식 입력: ");
        return readString();
    }

    private static String readString() {
        return SCANNER.nextLine();
    }

}
