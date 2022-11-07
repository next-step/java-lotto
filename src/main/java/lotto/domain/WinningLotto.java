package lotto.domain;

import java.util.List;

import lotto.exception.DuplicateBonusNumberException;
import lotto.exception.ErrorMessage;

public class WinningLotto extends Lotto {
	private final int bonusNumber;

	public WinningLotto(List<Integer> numbers, int bonusNumber) {
		super(numbers);
		if (!isValidBonusNumber(bonusNumber)) {
			throw new DuplicateBonusNumberException(ErrorMessage.BONUS_NUMBER_MUST_NOT_BE_DUPLICATED);
		}
		this.bonusNumber = bonusNumber;
	}

	private boolean isValidBonusNumber(int bonusNumber) {
		return !numbers.contains(bonusNumber);
	}
}
