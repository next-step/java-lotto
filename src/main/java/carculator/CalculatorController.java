package carculator;

import carculator.domain.Calculator;
import carculator.view.input.ConsoleInputView;
import carculator.view.output.OutputView;

public class CalculatorController {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new ConsoleInputView(), new OutputView());
        calculator.run();
    }
}
