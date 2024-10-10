package textcalculator;

import textcalculator.domain.TextCalculator;
import textcalculator.ui.ConsoleInputView;
import textcalculator.ui.ConsoleResultView;
import textcalculator.ui.InputView;
import textcalculator.ui.ResultView;

public class Client {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        ResultView resultView = new ConsoleResultView();

        String formula = inputView.getFormulaFromUser();
        TextCalculator textCalCulator = new TextCalculator(formula);
        int result = textCalCulator.calculate();

        resultView.showResult(result);
    }
}
