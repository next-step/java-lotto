package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final String START_MESSAGE = "계산할 문자열을 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputString() {
        System.out.println(START_MESSAGE);
        return scanner.nextLine();
    }
}
