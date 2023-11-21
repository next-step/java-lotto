package stringcalculator.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_COMMAND = "문자열을 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputString() {
        System.out.println(INPUT_COMMAND);
        return scanner.next();
    }
}
