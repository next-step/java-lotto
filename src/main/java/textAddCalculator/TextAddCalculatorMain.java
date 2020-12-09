package textAddCalculator;

import textAddCalculator.domain.Calculator;
import textAddCalculator.view.InputView;
import textAddCalculator.view.OutputView;

public class TextAddCalculatorMain {
    public static void main(String[] args) {
        String text = InputView.inputText();
        Calculator calculator = new Calculator();
        OutputView.showResult(calculator.splitAndSum(text));
    }
}
