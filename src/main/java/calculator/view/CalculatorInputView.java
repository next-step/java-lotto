package calculator.view;

import java.util.Scanner;

public class CalculatorInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private CalculatorInputView() {

    }

    public static String inputArithmeticExpression() {
        System.out.println("연산식을 입력해주세요.");
        return SCANNER.nextLine();
    }
}
