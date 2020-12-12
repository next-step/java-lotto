package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResults {
	private Map<LottoRank, Integer> results;

	public LottoResults() {
		this.results = new EnumMap<>(LottoRank.class);
		for (LottoRank rank : LottoRank.values()) {
			this.results.put(rank, 0);
		}
	}

	public void addResult(LottoRank rank) {
		int updatedCount = this.results.get(rank) + 1;
		this.results.put(rank, updatedCount);
	}

	public int getResultCount(LottoRank place) {
		return this.results.get(place);
	}

	public long getTotalEarnings() {
		return this.results.keySet()
			.stream()
			.mapToLong(rank -> rank.calculateEarnings(results.get(rank)))
			.sum();
	}

	public double getEarningRate(int payment) {
		return (double) this.getTotalEarnings() / payment;
	}
}
