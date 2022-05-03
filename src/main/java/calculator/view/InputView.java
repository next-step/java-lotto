package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PRINT_INPUT_FORMULA = "계산할 숫자와 연산자를 입력해주세요 : ";
    public static String inputFormulaString() {
        printInputFormula();
        return scanner.nextLine();
    }

    private static void printInputFormula() {
        System.out.print(PRINT_INPUT_FORMULA);
    }
}
