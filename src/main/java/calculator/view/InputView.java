package calculator.view;

import calculator.util.Console;

public class InputView {

    private InputView() {}

    public static String readFormula() {
        String formula = "";
        OutputView.printRequestFormulaInput();

        try {
            formula = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.err.println(OutputView.ERROR + e.getMessage());
        }

        return formula;
    }

}

