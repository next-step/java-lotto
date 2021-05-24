package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

	private List<Number> numbers;

	public Numbers(String[] numbers) {
		this.numbers = StringToNumbers(numbers);
	}

	public int sum() {
		return numbers.stream().mapToInt(Number::value).sum();
	}

	private List<Number> StringToNumbers(String[] numbers) {
		return Arrays.stream(numbers).map(Number::new).collect(Collectors.toList());
	}
}
