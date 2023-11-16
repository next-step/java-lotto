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
        String origin = inputView.calculatorString();
        List<String> strings = splitStrings(origin);
        Variable expression = Calculator.calculate(strings);
        resultView.calculateResult(expression.value());
    }

    private static List<String> splitStrings(String origin) {
        return Arrays.asList(origin.split(" "));
    }
}
