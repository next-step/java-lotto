package step1.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String readExpression() {
        System.out.println("공백으로 구분된 수식을 입력하세요.");
        return scanner.nextLine();
    }
}
