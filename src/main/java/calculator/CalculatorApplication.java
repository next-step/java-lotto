package calculator;

import calculator.domain.Calculator;
import calculator.ui.InputView;
import calculator.ui.OutputView;

import java.util.List;

public class CalculatorApplication {
    public static void main(String[] args) {
        List<String> strings = InputView.input();

        Calculator calculator = new Calculator(strings);

        OutputView.output(calculator.calculate());
    }
}
