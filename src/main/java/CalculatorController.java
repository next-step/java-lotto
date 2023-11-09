public class CalculatorController {
	private final Calculator calculator;

	public CalculatorController(Calculator calculator) {
		this.calculator = calculator;
	}

	public void main() {
		String[] inputs = InputView.inputExpression();
		calculator.calculate(inputs);
		OutputView.printResult(calculator);
	}
}
