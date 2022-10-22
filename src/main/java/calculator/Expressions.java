package calculator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Expressions {

	private static final Pattern OPERATOR_REGEX = Pattern.compile("\\D");
	private static final Pattern NUMBER_REGEX = Pattern.compile("\\d+");

	private final List<Operator> operators;
	private final List<Integer> numbers;

	public Expressions(List<String> expressions) {
		validateNotNull(expressions);
		validateNotContainingBlank(expressions);

		this.operators = getOperators(expressions);
		this.numbers = getNumbers(expressions);
	}

	public int calculate() {
		Iterator<Operator> operatorIterator = operators.iterator();
		return numbers.stream()
			.reduce((number, otherNumber) -> operatorIterator.next().calculate(number, otherNumber))
			.orElseThrow(() -> new RuntimeException("연산할 숫자가 없습니다."));
	}

	private List<Integer> getNumbers(List<String> expressions) {
		return expressions.stream()
			.filter(this::isNumber)
			.map(Integer::parseInt)
			.collect(Collectors.toUnmodifiableList());
	}

	private boolean isNumber(String expression) {
		return NUMBER_REGEX.matcher(expression).matches();
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
