package calculator;

import java.util.List;

public abstract class StringSeparator {

	List<String> separate(String input){
		validate(input);

		return splitByDelimiter(input);
	}

	private static void validate(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("공백 또는 null을 입력하셨습니다.");
		}
	}

	protected abstract List<String> splitByDelimiter(String input);

}
