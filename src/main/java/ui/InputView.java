package ui;

import exception.InvalidFormularException;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMETER = " ";
    public static final String OPERATOR_REGEX = "[-*/+]";

    private InputView() {
    }

    public static String[] inputFormula() {
        String formula = SCANNER.nextLine();
        return convertStringToArray(formula);
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
