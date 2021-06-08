package com.nextstep.lotto.lotto;

import com.nextstep.lotto.result.LottoRank;

public class WinningLotto {
	private final Lotto winningLotto;

	public WinningLotto(Lotto winningLotto) {
		this.winningLotto = winningLotto;
	}

	public LottoRank matchRank(Lotto lotto) {
		return LottoRank.valueOf(lotto.match(winningLotto));
	}
}
