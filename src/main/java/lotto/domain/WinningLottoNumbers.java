package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

import lotto.exception.InvalidLottoNumberSizeException;

public class WinningLottoNumbers {

	private static final int VALID_NUMBER_SIZE = 6;

	private final List<Integer> winningNumbers;

	private WinningLottoNumbers(List<Integer> winningNumbers) {
		validateWinningNumbers(winningNumbers);
		this.winningNumbers = winningNumbers;
	}

	public static WinningLottoNumbers from(List<Integer> winningNumbers) {
		List<Integer> numbers = winningNumbers.stream()
									.distinct()
									.collect(collectingAndThen(toList(), Collections::unmodifiableList));
		return new WinningLottoNumbers(numbers);
	}

	public List<Integer> getWinningNumbers() {
		return Collections.unmodifiableList(winningNumbers);
	}

	private void validateWinningNumbers(List<Integer> winningNumbers) {
		if (hasInvalidSize(winningNumbers)) {
			throw new InvalidLottoNumberSizeException(winningNumbers.size());
		}
	}

	private boolean hasInvalidSize(List<Integer> winningNumbers) {
		return winningNumbers.size() != VALID_NUMBER_SIZE;
	}
}
