package step1.view;

import step1.exception.InvalidInputException;
import step1.model.NumberCalculation;

import java.util.Scanner;

public class ClientView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DEFAULT_PATTERN = "\\s+";

    public static String[] scanCalculationFormula() {
        System.out.println("수식을 입력해주세요.");

        final String input = SCANNER.nextLine();

        if (input == null || input.isBlank()) {
            throw new InvalidInputException("[입력 오류] 입력 값이 null 또는 빈 공백 입니다.");
        }

        return input.split(DEFAULT_PATTERN);
    }

    public static void showResult(NumberCalculation numberCalculation) {
        System.out.println(numberCalculation.getNumber());
    }
}
