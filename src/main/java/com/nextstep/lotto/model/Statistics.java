package com.nextstep.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Statistics implements Printable {

	private WinningLotto winningLotto;
	private Lottos lottos;
	private LottoResult lottoResult;

	public Statistics(WinningLotto winningLotto, Lottos lottos) {
		this.winningLotto = winningLotto;
		this.lottos = lottos;
	}

	public void generateLottoResult() {
		List<LottoMatch> lottoMatches = new ArrayList<>();
		List<LottoNumber> winningNumbers = winningLotto.getWinningLotto().getLottoNumbers();

		for (Lotto lotto : lottos.getLottos()) {
			List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
			lottoNumbers.retainAll(winningNumbers);
			lottoMatches.add(new LottoMatch(lottoNumbers.size()));
		}
		lottoResult = new LottoResult(lottoMatches);
	}

	public LottoResult getLottoResult() {
		return this.lottoResult;
	}

	@Override
	public void print() {
		System.out.println(STATISTICS_HEAD_STRING);
		for (int i = 1; i <= Lotto.LOTTO_SIZE; i++) {
			System.out.println(
				String.format(
					NUMBER_MATCH_STRING
					, i
					, RevenueCalculator.valueOf(i).getRevenue()
					, getWinningCount(i)
				)
			);
		}
	}

	private long getWinningCount(int matchCount) {
		return this.lottoResult.lottoMatches()
			.stream()
			.filter(lottoMatch -> lottoMatch.getMatchedCount() == matchCount)
			.count();
	}
}
