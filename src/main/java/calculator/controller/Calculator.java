package calculator.controller;

import calculator.domain.Expression;
import calculator.domain.Operand;
import calculator.view.CalculatorView;

public class Calculator {

    private final CalculatorView calculatorView;

    public Calculator(final CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
    }

    public void run() {
        try {
            final String[] expressionTokens = calculatorView.readExpressionTokens();
            final Expression expression = Expression.from(expressionTokens);

            final Operand result = expression.calculate();

            calculatorView.printCalculationResult(result);

        } catch (final IllegalArgumentException e) {
            calculatorView.printBusinessExceptionMessage(e.getMessage());

        } catch (final Exception e) {
            calculatorView.printUnexpectedExceptionMessage();
        }
    }
}
