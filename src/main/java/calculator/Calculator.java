package calculator;

public class Calculator {

	public int sum(int input1, int input2) {
		return input1 + input2;
	}

	public int substact(int input1, int input2) {
		return input1 - input2;
	}

	public int multiply(int input1, int input2) {
		return input1 * input2;
	}

	public int divide(int input1, int input2) {
		return input1 / input2;
	}

	public int calculate(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("null 또는 공백은 입력할 수 없습니다.");
		}

		return 0;
	}

}
