package calculator;

import calculator.calculator.IntegerCalculator;
import calculator.parser.ArithmeticExpressionExpressionValidator;
import calculator.parser.ExpressionParser;
import calculator.parser.converter.IntegerStringConverter;
import calculator.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        IntegerCalculator calculator =
                new IntegerCalculator(new ExpressionParser(
                        new IntegerStringConverter(),
                        new ArithmeticExpressionExpressionValidator(" "),
                        " "));

        String expression = consoleView.inputExpression();
        consoleView.printResult(calculator.calculate(expression));
    }
}
