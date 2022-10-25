package step1.model;

import java.util.Arrays;

public class Operations {
	private static final String PATTERN = "[0-9+\\-*/]";
	private static final String SPLIT_DELIMITER = " ";

	private final String[] operation;

	public Operations(final String input) {
		checkInputStatus(input);
		this.operation = input.split(SPLIT_DELIMITER);
		checkOperationStatus(operation);
	}

	private void checkInputStatus(final String input) {
		if (input == null || input.isBlank()) throw new IllegalArgumentException("입력연산은 적어도 한글자 이상이어야 합니다.");
	}

	public void checkOperationStatus(final String[] operation) {
		Arrays.stream(operation)
				.filter(s -> !s.matches(PATTERN))
				.forEachOrdered(s -> {
					throw new IllegalArgumentException("입력된 연산에 연산자 또는 숫자가 아닌 문자가 입력되어있습니다.");
				});
	}

	public String[] getOperations() {
		return operation;
	}
}
