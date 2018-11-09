package lotto.domain;

import lotto.enums.Prize;

public class WinningLotto {

	private Lotto winningNumber;
	private LottoNumber bonusNumber;

	public WinningLotto(Lotto winningNumber, Integer bonusNumber) {
		this(winningNumber, new LottoNumber(bonusNumber));
	}

	public WinningLotto(Lotto winningNumber, LottoNumber bonusNumber) {
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
