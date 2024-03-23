package calculator;

import calculator.controller.Calculator;
import calculator.view.CalculatorView;
import calculator.view.io.console.ConsoleInput;
import calculator.view.io.console.ConsoleOutput;

public final class CalculatorApplication {

    private CalculatorApplication() {
    }

    public static void main(final String[] args) {
        final CalculatorView calculatorView = new CalculatorView(new ConsoleInput(), new ConsoleOutput());

        new Calculator(calculatorView).run();
    }
}
