package com.nextstep.lotto.lotto;

import java.util.List;

import com.nextstep.lotto.result.LottoResult;

public class Lottos {
	private final List<Lotto> userLottos;

	public Lottos(List<Lotto> userLottos) {
		this.userLottos = userLottos;
	}

	public LottoResult matchRank(WinningLotto winningLotto) {
		LottoResult lottoResult = new LottoResult();
		for (Lotto lotto : userLottos) {
			lottoResult.addResult(winningLotto.matchRank(lotto));
		}
		return lottoResult;
	}

	public List<Lotto> userLottos() {
		return this.userLottos;
	}
}
