package stringcaculator;

import stringcaculator.controller.Calculator;
import stringcaculator.view.InputView;
import stringcaculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        String expression = InputView.getNumbers();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(expression);
        OutputView.printCalculatedResult(result);
    }
}
