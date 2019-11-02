package calculator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MESSAGE = "문자열을 입력 해 주세요.";

    public static String getInput() {
        System.out.println(INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
