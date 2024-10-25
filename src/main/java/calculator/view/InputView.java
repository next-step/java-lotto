package calculator.view;

import calculator.utility.validator.Validator;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER= new Scanner(System.in);

    private InputView() {
    }

    public static String inputCalculationString() {
        System.out.println("계산할 문자열을 입력하세요.(단, 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있어야 합니다.)");

        String calculateString = SCANNER.nextLine();

        Validator.isValidInput(calculateString);

        return calculateString;
    }
}
