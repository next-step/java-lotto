package calculator.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String INPUT_DESCRIPTION = "문자열을 입력해 주세요.";

    public static String input() {
        System.out.println(INPUT_DESCRIPTION);
        return SCANNER.next();
    }
}
