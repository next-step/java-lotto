package calculator.controller;

import calculator.domain.Expression;
import calculator.domain.parser.ArithmeticParser;
import calculator.domain.parser.Parser;
import calculator.view.CalculatorView;

public class Calculator {

    private final CalculatorView calculatorView;

    public Calculator(final CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
    }

    public void run() {
        try {
            final String text = calculatorView.readExpressionText();
            final Parser parser = new ArithmeticParser();
            final Expression expression = Expression.of(text, parser);

            final int result = expression.calculate();

            calculatorView.printCalculationResult(result);

        } catch (final IllegalArgumentException e) {
            calculatorView.printBusinessExceptionMessage(e.getMessage());

        } catch (final Exception e) {
            calculatorView.printUnexpectedExceptionMessage();
        }
    }
}
