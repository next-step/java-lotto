package im.juniq.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
	private List<Integer> winningNumbers = new ArrayList<>();

	public WinningNumbers(String[] numbers) {
		for (String number : numbers) {
			winningNumbers.add(Integer.parseInt(number));
		}
	}

	public WinningNumbers(Integer... numbers) {
		winningNumbers.addAll(Arrays.asList(numbers));
	}

	public boolean find(int number) {
		return winningNumbers.contains(number);
	}
}
