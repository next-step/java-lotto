package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        Calculator calculator = new Calculator(inputView.inputFormula());

        calculator.calculateWholeFormula();

        OutputView.showResult(calculator);

        inputView.close();
    }
}
