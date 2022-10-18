package calculator.view;

import java.util.Scanner;

public class CalculatorInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputArithmeticExpression() {
        System.out.println("연산식을 입력해주세요.");
        return scanner.nextLine();
    }
}
