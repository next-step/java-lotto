package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumbers {

	private static final int VALID_NUMBER_SIZE = 6;

	private final List<Integer> winningNumbers;

	private WinningLottoNumbers(List<Integer> winningNumbers) {
		validateWinningNumbers(winningNumbers);
		this.winningNumbers = winningNumbers;
	}

	public static WinningLottoNumbers from(List<Integer> winningNumbers) {
		List<Integer> collect = winningNumbers.stream()
									.distinct()
									.collect(Collectors.toList());
		return new WinningLottoNumbers(collect);
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	private void validateWinningNumbers(List<Integer> winningNumbers) {
		if (hasInvalidSize(winningNumbers)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean hasInvalidSize(List<Integer> winningNumbers) {
		return winningNumbers.size() != VALID_NUMBER_SIZE;
	}
}
