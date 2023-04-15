package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.ResultView;

import java.util.Scanner;

public class CalculatorApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = InputView.readInput(scanner);
        ResultView.printResult(calculate(input));
    }

    private static int calculate(String input) {
        Calculator calculator = new Calculator();
        calculator.insert(input);
        return calculator.calculate();
    }
}
