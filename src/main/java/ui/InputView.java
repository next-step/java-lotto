package ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMETER = " ";

    private InputView() {
    }

    public static String[] inputFormula() {
        String formula = SCANNER.nextLine();
        return convertStringToArray(formula);
    }

    public static String[] convertStringToArray(String formula) {
        return formula.split(DELIMETER);
    }
}
