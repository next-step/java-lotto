package calculator;

import calculator.model.Formula;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Main {

    public static void main(String args[]) {
        String formulaString = InputView.inputFormulaString();

        StringCalculator calculationString = new StringCalculator(new Formula(formulaString));
        int resultNumber = calculationString.start();

        OutputView.printResult(resultNumber);
    }
}
