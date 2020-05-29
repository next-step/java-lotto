package lotto;

import java.util.List;

public class WinningNumbers {

	private List<Integer> numbers;

	public WinningNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public boolean contains(int number) {
		return numbers.contains(number);
	}

	public int size() {
		return numbers.size();
	}
}
