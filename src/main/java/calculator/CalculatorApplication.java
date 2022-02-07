package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorApplication {

    public static void main(String[] args) {
        String text = InputView.inputText();

        Calculator calculator = new Calculator();
        ResultView.printResult(calculator.add(text));
    }
}
