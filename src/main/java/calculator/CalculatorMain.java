package calculator;

import view.InputView;
import view.OutputView;

public class CalculatorMain {

    public static void main(String[] args) {
        String[] text = InputView.inputText();
        int result = Calculator.calculate(text);
        OutputView.printResult(result);
    }
}
