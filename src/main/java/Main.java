import calculator.domain.Calculator;
import calculator.io.InputView;
import calculator.io.PrintView;

public class Main {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		PrintView.printResult(calculator.calculate(InputView.inputExpression()));
	}
}
