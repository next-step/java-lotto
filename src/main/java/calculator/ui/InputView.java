package calculator.ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CALCULATOR_QUESTION = "계산기에 값을 입력해주세요";

    public static String input() {
        System.out.println(CALCULATOR_QUESTION);
        return scanner.nextLine();
    }
}
