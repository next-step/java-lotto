package lotto.domain;

import java.util.List;

import lotto.exception.DuplicateBonusNumberException;
import lotto.exception.ErrorMessage;

public class WinningLotto extends Lotto {
	private final LottoNum bonusNumber;

	public WinningLotto(List<LottoNum> numbers, LottoNum bonusNumber) {
		super(numbers);
		if (!isValidBonusNumber(bonusNumber)) {
			throw new DuplicateBonusNumberException(ErrorMessage.BONUS_NUMBER_MUST_NOT_BE_DUPLICATED);
		}
		this.bonusNumber = bonusNumber;
	}

	private boolean isValidBonusNumber(LottoNum bonusNumber) {
		return !numbers.contains(bonusNumber);
	}

	public LottoNum getBonusNumber() {
		return bonusNumber;
	}
}
