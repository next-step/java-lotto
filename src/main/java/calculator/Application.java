package calculator;

import calculator.model.Formula;
import calculator.model.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String args[]) {
        String formulaString = InputView.inputFormulaString();

        StringCalculator stringCalculator = new StringCalculator(new Formula(formulaString));
        Number resultNumber = stringCalculator.calculate();

        OutputView.printResult(resultNumber);
    }
}
