package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

	private List<Integer> winningNumbers;

	public WinningNumber(String numbers) {
		winningNumbers = getWinningNumbers(numbers);
	}

	private List<Integer> getWinningNumbers(String numbers) {
		return Arrays.stream(numbers.split("[\\s,]+"))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
	}

	public boolean hasNumber(Integer number) {
		return winningNumbers.contains(number);
	}
}
