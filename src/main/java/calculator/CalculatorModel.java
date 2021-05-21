package calculator;

import static java.util.Objects.*;

public class CalculatorModel {

	private String userInput;

	public CalculatorModel(String userInput) {
		setUserInput(userInput);
	}

	private void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	public String userInput() {
		return userInput;
	}

	public long execute() {
		if (isBlank(userInput())) {
			return 0;
		}

		for (char c : userInput.toCharArray()) {

			if (c == '-' || Character.isAlphabetic(c)) {
				throw new RuntimeException("유효하지 않은 입력입니다");
			}

		}

		long sum = 0L;

		for (String s : userInput.split(",")) {
			sum += Long.parseLong(s);
		}

		return sum;
	}

	private boolean isBlank(String userInput) {
		return isNull(userInput) || userInput.equals("");
	}
}
