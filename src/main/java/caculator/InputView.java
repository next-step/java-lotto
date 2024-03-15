package caculator;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String inputExpression() {
        System.out.println("문자열 식을 입력하세요.");
        return SCANNER.nextLine();
    }
}
