package calculator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Expressions {

	private static final Pattern OPERATOR_REGEX = Pattern.compile("\\D");

	public Expressions(List<String> expressions) {
		validateNotNull(expressions);
		validateNotContainingBlank(expressions);

		List<Operator> operators = getOperators(expressions);
	}

	private List<Operator> getOperators(List<String> expressions) {
		return expressions.stream()
			.filter(this::isOperator)
			.map(Operator::new)
			.collect(Collectors.toUnmodifiableList());
	}

	private boolean isOperator(String expression) {
		return OPERATOR_REGEX.matcher(expression).matches();
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
