package camp.nextcamp.edu.calculator.entity;

import static camp.nextcamp.edu.util.StringUtils.*;

public class CalculatorNumberInput {
	private final String input;

	public CalculatorNumberInput(String input) {
		if (!isNumeric(input)) {
			throw new RuntimeException("0 이상의 정수만 가능합니다.");
		}
		this.input = input;
	}

	public int getInputTypeInt() {
		return Integer.parseInt(this.input);
	}
}
