package ui;

import exception.InvalidFormularException;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMETER = " ";
    private static final String OPERATOR_REGEX = "[-*/+]";
    private static final String USER_INPUT_MESSAGE = "문자열을 입력해주세요(ex. 2 + 3 * 4 / 2).";

    private InputView() {
    }

    public static String[] inputFormula() {
        System.out.println(USER_INPUT_MESSAGE);
        String formula = SCANNER.nextLine();
        try {
            return convertStringToArray(formula);
        } catch (InvalidFormularException e) {
            System.out.println(e.getMessage());
            return inputFormula();
        }
    }

    public static String[] convertStringToArray(String formula) {
        validateFormular(formula);
        return formula.split(DELIMETER);
    }

    private static void validateFormular(String formula) {
        int numberOfOperators = countNumberOfMatch(formula, OPERATOR_REGEX);
        int numberOfDelimeter = countNumberOfMatch(formula, DELIMETER);
        if (numberOfDelimeter != numberOfOperators * 2) {
            throw new InvalidFormularException(numberOfDelimeter, numberOfOperators * 2);
        }
    }

    private static int countNumberOfMatch(String target, String match) {
        return target.length() - target.replaceAll(match, "").length();
    }
}
