package calculator;

import java.util.List;

public class Expressions {

	public Expressions(List<String> expressions) {
		validateNotNull(expressions);
		validateNotContainingBlank(expressions);
	}

	private void validateNotNull(List<String> expressions) {
		if (expressions == null) {
			throw new IllegalArgumentException("수식은 null일 수 없습니다");
		}
	}

	private void validateNotContainingBlank(List<String> expressions) {
		for (String expression : expressions) {
			validateNotBlank(expression);
		}
	}

	private void validateNotBlank(String expression) {
		if (expression.isBlank()) {
			throw new IllegalArgumentException("수식은 공백일 수 없습니다");
		}
	}
}
