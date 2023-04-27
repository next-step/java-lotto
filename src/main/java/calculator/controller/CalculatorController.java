package calculator.controller;

import calculator.domain.expression.ExpressionCalculator;
import calculator.domain.expression.ExpressionParser;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorController {
    public void run() {
        String calculationExpression = InputView.getUserInput();
        ExpressionParser parser = ExpressionParser.of(calculationExpression);
        int calculationResult = ExpressionCalculator.calculateExpression(parser.extractOperands(), parser.extractOperators());
        ResultView.showResult(calculationResult);
    }
}
