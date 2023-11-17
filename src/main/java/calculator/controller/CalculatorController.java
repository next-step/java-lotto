package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Variable;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorController {

    private final InputView inputView;
    private final ResultView resultView;

    public CalculatorController(Scanner scanner, PrintStream printStream) {
        this.inputView = new InputView(scanner, printStream);
        this.resultView = new ResultView(printStream);
    }

    public static CalculatorController of(Scanner scanner, PrintStream printStream) {
        return new CalculatorController(scanner, printStream);
    }

    public void calculate() {
        Calculator calculator = Calculator.of(inputView.calculatorString());
        Variable expression = calculator.calculate();
        resultView.calculateResult(expression.value());
    }

}
