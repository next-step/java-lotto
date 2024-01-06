package lotto.domain;

import java.util.Map;

public final class LottoResult {
	private final Map<Rank, Integer> lottoResultMap;

	public LottoResult(final Map<Rank, Integer> lottoResultMap) {
		this.lottoResultMap = lottoResultMap;
	}

	public float calculateRate(final int totalPrice) {
		return (float)totalPrize() / (float)totalPrice;
	}

	private int totalPrize() {
		int totalPrize = 0;

		for (Rank rank : Rank.values()) {
			totalPrize += Rank.calculate(rank, lottoResultMap.getOrDefault(rank, 0));
		}

		return totalPrize;
	}

	public int rankCount(final Rank rank) {
		return lottoResultMap.get(rank);
	}
}
