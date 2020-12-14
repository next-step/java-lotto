package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMatchResults {
	private Map<LottoRank, Integer> results;
	private final long payment;

	public LottoMatchResults(long payment) {
		this.payment = payment;
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

	public double getEarningRate() {
		return (double) this.getTotalEarnings() / this.payment;
	}

	public boolean isLoss() {
		return this.getEarningRate() < 1;
	}

	@Override
	public String toString() {
		return this.results.keySet().stream()
			.filter(LottoRank::isNotNoting)
			.map(rank -> String.format("%s - %d 개", rank.toString(), results.get(rank)))
			.collect(Collectors.joining("\n"));
	}
}
