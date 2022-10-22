package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String expr = InputView.readExpression();
        Calculator calculator = new Calculator(expr);
        OutputView.printResult(calculator.calculate());
    }
}
