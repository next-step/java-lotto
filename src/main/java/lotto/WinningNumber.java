package lotto;

import java.util.Collections;
import java.util.List;

public class WinningNumber {
	private final List<Integer> winningNumbers;

	public WinningNumber(List<Integer> winningNumbers) {
		this.winningNumbers = Collections.unmodifiableList(winningNumbers);
	}

	public long match(List<Integer> numbers) {
		return numbers.stream()
			.filter(this::isContains)
			.count();
	}

	private boolean isContains(int number) {
		return this.winningNumbers.contains(number);
	}
}
