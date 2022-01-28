package view;

import util.Console;

public class InputView {

    private InputView() {}

    public static String readFormula() {
        String formula = "";
        OutputView.printRequestFormulaInput();

        try {
            formula = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.err.println("[Error] " + e.getMessage());
        }

        return formula;
    }

}

