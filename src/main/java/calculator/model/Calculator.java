package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static final String CALCULATE_SEPARATOR_COMMA = ",";
	public static final String CALCULATE_SEPARATOR_COLON = ":";
	private final List<String> expression;

	public Calculator(String userInput) {
		
		this.expression = getExpression(userInput);
	}

	public List<String> getExpressionList() {
		return this.expression;
	}


	public List<String> getExpression(String userInput) {

		return splitExpression(splitUserSeparator(userInput));
	}

	public List<String> splitExpression(List<String> strings) {

		List<String> result = new ArrayList<>();
		for (String str : strings) {

			result.addAll(Arrays.asList(str.split("[" + CALCULATE_SEPARATOR_COMMA + CALCULATE_SEPARATOR_COLON + "]")));
		}

		return result;
	}

	public int calculate() {

		return expression.stream()
			.mapToInt(Integer::parseInt)
			.sum();
	}

	public List<String> splitUserSeparator(String expression) {

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
		if (m.find()) {

			String customDelimiter = m.group(1);
			String[] tokens= m.group(2).split(customDelimiter);

			return Arrays.asList(tokens);
		}

		return Collections.singletonList(expression);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Calculator that = (Calculator)o;
		return Objects.equals(expression, that.expression);
	}

	@Override
	public int hashCode() {
		return Objects.hash(expression);
	}
}
