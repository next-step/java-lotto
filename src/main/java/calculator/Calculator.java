package calculator;

public class Calculator {

	public static final String DELIMITER = " ";

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

		String[] s = input.split(DELIMITER);
		// 완성된 계산식은 숫자 + 연산자의 갯수가 홀수여야한다.
		if (s.length % 2 != 1) {
			throw new IllegalArgumentException("잘못된 계산식 입니다.");
		}

		return 0;
	}

}
