package study;

public class Calculator {

	public int run(String input) {
		InputSplit inputSplit = new InputSplit();
		String[] numbers = inputSplit.split(input);
		int sum = sum(numbers);
		return sum;
	}

	private int sum(String[] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += validatePositiveNumber(numbers[i]);
		}
		return sum;
	}

	private int validatePositiveNumber(String input) {
		if (input.contains("-")) {
			throw new RuntimeException("음수는 포함될 수 없습니다.");
		}
		return Integer.valueOf(input);
	}
}
