package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public final class LottoResult {
	private final Map<Rank, Integer> lottoResultMap = new HashMap<>();

	public LottoResult() {
		for (Rank rank : Rank.values()) {
			lottoResultMap.put(rank, 0);
		}
	}

	public double calculateRate(final int totalPrice) {
		return totalPrize() / (double)totalPrice;
	}

	private double totalPrize() {
		double totalPrize = 0;

		for (Rank rank : Rank.values()) {
			totalPrize += Rank.calculate(rank, lottoResultMap.get(rank));
		}

		return totalPrize;
	}

	public int rankCount(final Rank rank) {
		return lottoResultMap.get(rank);
	}

	public void addCount(Rank rank) {
		this.lottoResultMap.replace(rank, this.lottoResultMap.get(rank) + 1);
	}

	public Map<Rank, Integer> lottoResultMap() {
		return lottoResultMap;
	}
}
