package calculator.view;

import calculator.domain.Validator;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String inputFormula() {
        System.out.println("수식을 입력하세요.");
        String inputFormula = SCANNER.nextLine();

        return inputFormula;
    }
}
