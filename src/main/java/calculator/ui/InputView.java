package calculator.ui;

import java.util.Scanner;

public class InputView {
    private static final String CALCUATE_INPUT_MESSAGE = "계산식을 입력하세요.";
    private static final Scanner Scanner = new Scanner(System.in);

    public static String getExpression() {
        System.out.println(CALCUATE_INPUT_MESSAGE);
        return Scanner.nextLine();
    }
}
