package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumbers {

	private static final String DELIMITER = ",";

	private final List<Integer> winningNumbers;

	private WinningLottoNumbers(List<Integer> winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public static WinningLottoNumbers from(String winningNumbers) {
		List<Integer> numbers = Arrays.stream(winningNumbers.trim().split(DELIMITER))
									.map(Integer::parseInt)
									.collect(Collectors.toList());
		return new WinningLottoNumbers(numbers);
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}
}
