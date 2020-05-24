package calculator;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MESSAGE = "계산할 문자열을 입력하세요.";

    private InputView() {
    }

    public static String getUserInput() {
        System.out.println(INPUT_MESSAGE);
        return scanner.next();
    }
}
