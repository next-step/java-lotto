package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApplication {
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String input = inputView.input();

        long value = calculator.calculate(input);

        OutputView outputView = new OutputView();
        outputView.print(value);
    }
}
