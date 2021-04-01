package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
	private List<Integer> winningNumbers = new ArrayList<>();
	private int bonusNumber;

	public WinningNumbers(List<Integer> numbers, int bonusNumber) {
		winningNumbers.addAll(numbers);
		this.bonusNumber = bonusNumber;
	}

	public boolean existent(int number) {
		return winningNumbers.contains(number);
	}

	public boolean matchedBonusNumber(int number) {
		return bonusNumber == number;
	}
}
