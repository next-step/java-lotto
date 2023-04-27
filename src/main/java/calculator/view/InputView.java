package calculator.view;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String START_INPUT_MESSAGE = "계산할 문자열을 입력하세요";

    public static String getUserInput() {
        System.out.println(START_INPUT_MESSAGE);
        return SCANNER.nextLine();
    }
}
