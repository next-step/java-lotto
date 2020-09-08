package stringcalculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static String expressionValue() {
        System.out.println("문자열 덧셈 수식을 입력해주세요");
        return scanner.nextLine();
    }
}
