package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

	private List<Integer> winningNumbers = new ArrayList<>();

	public WinningNumbers(int[] numbers) {
		for (int i = 0, len = numbers.length; i < len; i++) {
			winningNumbers.add(numbers[i]);
		}
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

}
