package step1.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputExpression() {
        System.out.println("사칙연산할 식을 입력해 주세요.");
        return scanner.nextLine();
    }
}
