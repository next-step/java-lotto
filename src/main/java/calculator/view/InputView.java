package calculator.view;

import calculator.util.Console;

public class InputView {

    private InputView() {}

    public static String readFormula() {
        try {
            String formula = Console.readLine();
            return formula;
        } catch (IllegalArgumentException e) {
            System.err.println(OutputView.ERROR + e.getMessage());
            System.exit(0);
        }
        return readFormula();
    }
}
