package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

	private List<Number> numbers;

	public Numbers(StringNumber stringNumber) {
		numbers = parseNumbers(stringNumber.getStringNumbers());
	}

	private List<Number> parseNumbers(String[] stringNumbers) {
		List<Number> numbers = new ArrayList<>();
		for (String stringNumber : stringNumbers) {
			numbers.add(new Number(stringNumber));
		}
		return numbers;
	}

	public int addAll() {
		int result = 0;
		for (Number number : numbers) {
			result = number.add(result);
		}
		return result;
	}
}
