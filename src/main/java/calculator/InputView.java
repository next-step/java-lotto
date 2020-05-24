package calculator;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private static final String INPUT_MESSAGE = "계산할 문자열을 입력하세요.";

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        System.out.println(INPUT_MESSAGE);
        return scanner.next();
    }
}
