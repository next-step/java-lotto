package com.nextstep.lotto.lotto;

import com.nextstep.lotto.result.LottoRank;

public class WinningLotto {
	private final Lotto winningLotto;
	private final LottoNumber bonusNumber;

	public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
		this.winningLotto = winningLotto;
		this.bonusNumber = bonusNumber;
	}

	public LottoRank matchRank(Lotto lotto) {
		boolean isBonusMatch = lotto.contains(bonusNumber);
		return LottoRank.valueOf(lotto.match(winningLotto), isBonusMatch);
	}
}
