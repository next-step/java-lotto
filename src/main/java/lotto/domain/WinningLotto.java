package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.exception.DuplicateBonusNumberException;
import lotto.exception.ErrorMessage;

public class WinningLotto extends Lotto {
	private final int bonusNumber;
	private final List<Integer> wholeNumbers;

	public WinningLotto(List<Integer> numbers, int bonusNumber) {
		super(numbers);
		if (!isValidBonusNumber(bonusNumber)) {
			throw new DuplicateBonusNumberException(ErrorMessage.BONUS_NUMBER_MUST_NOT_BE_DUPLICATED);
		}
		this.bonusNumber = bonusNumber;
		this.wholeNumbers = Stream.concat(numbers.stream(), Stream.of(bonusNumber)).collect(Collectors.toList());
	}

	private boolean isValidBonusNumber(int bonusNumber) {
		return !numbers.contains(bonusNumber);
	}

	public List<Integer> getWholeNumbers() {
		return wholeNumbers;
	}
}
