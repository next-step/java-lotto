package calculator.service;

import java.util.Set;

public class InputParser {
	private static final String DELIMITER = " ";
	private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

	public String[] parseTokens(String input) {
		validateInput(input);
		String[] tokens = input.split(DELIMITER);
		validateTokens(tokens);

		return tokens;
	}

	private void validateInput(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("입력값이 null 이거나 비어있습니다.");
		}
	}

	private void validateTokens(String[] tokens) {
		if (tokens.length % 2 == 0) {
			throw new IllegalArgumentException("Invalid input format");
		}

		for (int index = 0; index < tokens.length; index++) {
			validate(tokens[index], index);
		}
	}

	private void validate(String token, int index) {
		if (index % 2 == 0) {
			validateNumber(token);
			return;
		}

		validateOperator(token);
	}

	private void validateNumber(String token) {
		try {
			Integer.parseInt(token);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("올바르지 않은 숫자 입력: " + token, e);
		}
	}

	private void validateOperator(String token) {
		if (!OPERATORS.contains(token)) {
			throw new IllegalArgumentException("올바르지 않은 기호 입력: " + token);
		}
	}
}
