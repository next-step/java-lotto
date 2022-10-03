package step1.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MESSAGE = "계산식을 입력해주세요.";

    private final Scanner scanner = new Scanner(System.in);

    public String getExpression() {
        System.out.println(INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
