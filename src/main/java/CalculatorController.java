import java.util.Objects;

public class CalculatorController {
	private final static int ZERO = 0;
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
		checkDivisionByZero(inputExpression);
	}

	private void checkInputIsNullOrEmpty(String inputExpression) {
		if(inputExpression == null || inputExpression.isBlank()) {
			throw new IllegalArgumentException("유효한 계산식을 입력해주세요");
		}
	}

	private void checkDivisionByZero(String inputExpression) {
		String[] inputs = inputExpression.split(" ");
		for (int i = 1; i < inputs.length; i += 2) {
			String operator = inputs[i];
			int right = Integer.parseInt(inputs[i + 1]);
			if(isDividedByZero(operator, right)) {
				throw new IllegalArgumentException("0으로 나눗셈을 할 수 없습니다.");
			}
		}
	}

	private boolean isDividedByZero(String operator, int right) {
		return Objects.equals(operator, Operator.DIVISION.symbol()) && right == ZERO;
	}
}
