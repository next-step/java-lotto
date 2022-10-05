package calculator;

import calculator.model.Calculator;
import calculator.model.Expression;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Expression expression = InputView.inputExpression();

        int result = calculator.calculate(expression.getNumbers(), expression.getOperator());
        OutputView.printResult(result);
    }
}
