package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DEFAULT_MESSAGE = "수식을 입력해 주세요 (예 : 2 + 3 * 4 / 2) : ";

    private InputView() {

    }

    public static String requestText() {
        System.out.println(DEFAULT_MESSAGE);
        return scanner.nextLine();
    }

}
