package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import calculator.util.StringValid;

public class Expression {

	public static final String CALCULATE_SEPARATOR_COMMA = ",";
	public static final String CALCULATE_SEPARATOR_COLON = ":";
	public static final Pattern USER_ADD_SEPARATOR_FINDER = Pattern.compile("//(.)\n(.*)");

	private final List<Positive> numbers;

	public Expression(String userInputVal) throws IllegalArgumentException {

		validationExpression(userInputVal);
		this.numbers = getPositiveNumbers(userInputVal);
	}

	private List<Positive> getPositiveNumbers(String userInputVal) {

		return splitExpression(splitUserSeparator(userInputVal)).stream()
			.map(Positive::new)
			.collect(Collectors.toList());
	}

	private void validationExpression(String userInputVal) {

		if (StringValid.isEmptyStr(userInputVal)) {

			throw new IllegalArgumentException("수식을 입력하지 않으셨습니다.");
		}
	}

	public List<String> splitExpression(List<String> strings) {

		List<String> result = new ArrayList<>();
		for (String str : strings) {

			result.addAll(Arrays.asList(str.split("[" + CALCULATE_SEPARATOR_COMMA + CALCULATE_SEPARATOR_COLON + "]")));
		}

		return result;
	}

	public List<String> splitUserSeparator(String expression) {

		Matcher m = USER_ADD_SEPARATOR_FINDER.matcher(expression);
		if (m.find()) {

			String customDelimiter = m.group(1);
			String[] tokens = m.group(2).split(customDelimiter);

			return Arrays.asList(tokens);
		}

		return Collections.singletonList(expression);
	}

	public int sum() {

		return this.numbers.stream()
			.mapToInt(Positive::getPositiveNumber)
			.sum();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Expression that = (Expression)o;
		return Objects.equals(numbers, that.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
