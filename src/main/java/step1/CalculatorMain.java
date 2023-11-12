package step1;

import step1.domain.calculator.Calculator;
import step1.view.InputView;
import step1.view.OutputView;

public class CalculatorMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String[] inputValues = inputView.input();

        Calculator calculator = new Calculator();
        int result = Integer.valueOf(inputValues[0]);
        for (int i = 1; i < inputValues.length; i += 2) {
            calculator.updateOperator(inputValues[i]);
            result = calculator.calculate(result, Integer.valueOf(inputValues[i + 1]));
        }
        outputView.output(result);
    }
}
