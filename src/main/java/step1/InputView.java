package step1;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public InputView() {
    }

    public String requestExpression() {
        System.out.println("계산식을 입력해주세요.");
        return SCANNER.nextLine();
    }
}
