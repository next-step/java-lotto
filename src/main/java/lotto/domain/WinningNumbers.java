package lotto.domain;

import java.util.Set;

public class WinningNumbers {

	private Set<Integer> numbers;

	public WinningNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}

	public boolean contains(int number) {
		return numbers.contains(number);
	}

	public int size() {
		return numbers.size();
	}
}
