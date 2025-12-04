package calculator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputExpression() {
        System.out.print("수식을 입력하세요: ");
        return scanner.nextLine();
    }

}
