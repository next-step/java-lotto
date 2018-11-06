package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {

	private List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public boolean match(Integer winningNumber) {
		return numbers.contains(winningNumber);
	}

	@Override
	public String toString() {
		return Arrays.toString(numbers.toArray());
	}
}
