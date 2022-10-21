import domain.Calculator;
import view.InputView;
import view.OutputView;

public class CalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator = InputView.inputExpressions();
        int result = calculator.calculate(calculator.getNumbers(), calculator.getOperators());

        OutputView.printResult(result);
    }
}
