package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumbers {

	private static final int VALID_NUMBER_SIZE = 6;
	private static final String DELIMITER = ",";

	private final List<Integer> winningNumbers;

	private WinningLottoNumbers(List<Integer> winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public static WinningLottoNumbers from(String winningNumbers) {
		List<Integer> numbers = createNumbersFrom(winningNumbers);
		if (hasInvalidSize(numbers)) {
			throw new IllegalArgumentException();
		}
		return new WinningLottoNumbers(numbers);
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	private static List<Integer> createNumbersFrom(String winningNumbers) {
		return Arrays.stream(winningNumbers.trim().split(DELIMITER))
				.map(Integer::parseInt)
				.distinct()
				.collect(Collectors.toList());
	}

	private static boolean hasInvalidSize(List<Integer> numbers) {
		return numbers.size() != VALID_NUMBER_SIZE;
	}
}
