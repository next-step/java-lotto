package view;

import java.util.Scanner;

public class InputView {

    public static String getExpression() {
        System.out.println("계산할 수식을 입력하세요.");
        return getString();
    }

    private static String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
