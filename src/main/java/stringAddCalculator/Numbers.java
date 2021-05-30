package stringAddCalculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
	private static final int MAXIMUM_COUNT = 100;

	private List<Number> numbers = new ArrayList<>();

	public Numbers(String[] stringNumbers) {
		makeNumbers(stringNumbers);
		validateNumbersSize();
	}

	private void makeNumbers(String[] stringNumbers) {
		for (String stringNumber : stringNumbers) {
			numbers.add(new Number(stringNumber));
		}
	}

	private void validateNumbersSize() {
		if (numbers.size() > MAXIMUM_COUNT) {
			throw new RuntimeException("the number of numbers can not exceed one hundred");
		}
	}

	public int getSum() {
		int sum = 0;

		for (Number number : numbers) {
			sum += number.getNumber();
		}

		return sum;
	}
}
