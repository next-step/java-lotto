package calculator;

import calculator.domain.Calculator;
import calculator.domain.ParsedFormula;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        ParsedFormula parsedFormula = new ParsedFormula(inputView.inputFormula());
        Calculator.calculateWholeFormula(parsedFormula);

        OutputView.showResult(parsedFormula.getCurrentResult());

        inputView.close();
    }
}
