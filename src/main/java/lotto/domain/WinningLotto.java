package lotto.domain;

import lotto.enums.Prize;

public class WinningLotto {

	private Lotto winningNumber;
	private int bonusNumber;

	public WinningLotto(Lotto winningNumber, int bonusNumber) {
		this.winningNumber = winningNumber;
		this.bonusNumber = bonusNumber;
	}

	public Prize getPrize(Lotto lotto) {
		return Prize.of(winningNumber.match(lotto), hasBonusNumber(lotto));
	}

	private boolean hasBonusNumber(Lotto lotto) {
		return lotto.hasNumber(bonusNumber);
	}
}
