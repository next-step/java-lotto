package stringaddcalculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String getExpression() {
        System.out.println("계산할 식을 입력하세요.");
        return SCANNER.nextLine();
    }
}
