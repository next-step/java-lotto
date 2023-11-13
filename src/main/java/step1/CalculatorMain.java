package step1;

import step1.domain.calculator.Calculator;

import static step1.view.InputView.input;
import static step1.view.OutputView.output;

public class CalculatorMain {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        output(calculator.calculate(input()));
    }
}
