package study1;

public class Validation {

	Calculator calculator = new Calculator();

	public int emptyStringValidation(String str) {
		if (str == null) {
			return 0;
		}
		if (str.isEmpty()) {
			return 0;
		}
		return 0;
	}

	public void negativeValidation(String[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			negativeCheck(numbers[i]);
		}
	}

	public void negativeCheck(String numbers) {
		if (Integer.parseInt(numbers) < 0) {
			throw new IllegalArgumentException("음수를 입력하지 마세요");
		}

	}

}
