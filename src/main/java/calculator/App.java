package calculator;

import calculator.domain.Calculator;
import calculator.view.CalculatorInput;
import calculator.view.InputView;
import calculator.view.ResultView;

public class App {
    public static void main(String[] args) {
        CalculatorInput input = InputView.scanInput();
        int result = new Calculator(input.getInit(), input.getOperators()).calculate();
        ResultView.printResult(result);
    }
}
