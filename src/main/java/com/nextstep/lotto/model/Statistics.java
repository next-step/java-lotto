package com.nextstep.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

	private WinningLotto winningLotto;
	private Lottos lottos;

	public Statistics(WinningLotto winningLotto, Lottos lottos) {
		this.winningLotto = winningLotto;
		this.lottos = lottos;
	}

	public List<LottoResult> getLottoResult() {
		List<LottoResult> lottoResults = new ArrayList<>();
		List<LottoNumber> winningNumbers = winningLotto.getWinningLotto().getLottoNumbers();

		for (Lotto lotto : lottos.getLottos()) {
			List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
			lottoNumbers.retainAll(winningNumbers);
			lottoResults.add(new LottoResult(lottoNumbers.size()));
		}
		return lottoResults;
	}
}
