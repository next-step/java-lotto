package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorMain {

    public static void main(String[] args) {
        String[] text = InputView.inputText();
        int result = Calculator.calculate(text);
        OutputView.printResult(result);
    }
}
