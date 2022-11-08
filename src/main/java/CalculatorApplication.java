import domain.Calculator;
import domain.Expression;
import view.InputView;
import view.OutputView;

public class CalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Expression expression = InputView.inputExpressions();

        int result = calculator.calculate(expression.getNumbers(), expression.getOperators());
        OutputView.printResult(result);
    }
}

