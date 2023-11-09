package calculator.ui;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_TEXT = "사칙연산을 수행할 수 있는 문자열을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String text() {
        System.out.println(INPUT_TEXT);
        return scanner.next();
    }

}
