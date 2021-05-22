package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

	private List<Number> numbers;

	public Numbers() {
		this.numbers = new ArrayList<>();
	}

	public void add(Number number) {
		numbers.add(number);
	}

	public int sum() {
		int sum = 0;
		for(Number number : numbers) {
			sum += number.value();
		}
		return sum;
	}
}
