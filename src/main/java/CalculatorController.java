public class CalculatorController {
	private final Calculator calculator;

	public CalculatorController(Calculator calculator) {
		this.calculator = calculator;
	}

	public void calculate(String inputExpression) {
		validateInputExpression(inputExpression);

		String[] inputs = inputExpression.split(" ");
		calculator.calculate(inputs);

		OutputView.printResult(calculator);
	}

	private void validateInputExpression(String inputExpression) {
		checkInputIsNullOrEmpty(inputExpression);
	}

	private void checkInputIsNullOrEmpty(String inputExpression) {
		if(inputExpression == null || inputExpression.isBlank()) {
			throw new IllegalArgumentException("유효한 계산식을 입력해주세요");
		}
	}
}
