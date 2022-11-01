package calculator;

import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(InputView.inputLine());
        ResultView.printResult(calculator.calculate());
    }
}
