package im.juniq.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
	private List<Integer> winningNumbers = new ArrayList<>();
	private int bonusNumber;

	public WinningNumbers(List<Integer> numbers, int bonusNumber) {
		winningNumbers.addAll(numbers);
		this.bonusNumber = bonusNumber;
	}

	public WinningNumbers(String[] numbers) {
		for (String number : numbers) {
			winningNumbers.add(Integer.parseInt(number));
		}
	}

	public boolean existent(int number) {
		return winningNumbers.contains(number);
	}

	public boolean matchedBonusNumber(int number) {
		return bonusNumber == number;
	}
}
