package calculator.domain;

public class Calculator {
	public int calculate(String[] expression) {
		validExpression(expression);

		Number number = new Number(expression[0]);

		for (int i = 1; i < expression.length - 1; i = i + 2) {
			number = Operator.getOperatorBySymbol(expression[i])
					.calculate(number, new Number(expression[i + 1]));
		}

		return number.getNumber();
	}

	private void validExpression(String[] expression) {
		if (expression.length == 0) {
			throw new IllegalArgumentException("빈 값을 입력했습니다.");
		}

		if (expression.length < 3) {
			throw new IllegalArgumentException("식을 잘못 입력했습니다.");
		}

		if ((expression.length - 3) % 2 != 0) {
			throw new IllegalArgumentException("식을 잘못 입력했습니다.");
		}
	}
}
