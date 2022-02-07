package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputText() {
        System.out.println("문자열 덧셈 계산기");
        return SCANNER.nextLine();
    }
}
