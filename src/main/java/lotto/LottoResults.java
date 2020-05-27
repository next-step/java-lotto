package lotto;

import java.util.Map;

public class LottoResults {

	private final Map<Rank, Long> results;

	public LottoResults(Map<Rank, Long> results) {
		this.results = results;
	}

	public long getCounts(Rank rank) {
		return results.getOrDefault(rank, 0L);
	}

	public float getProfitRate() {
		return  (float) getPrizeMoneySum() / getSpentMoneySum();
	}

	private long getSpentMoneySum() {
		return results.values().stream()
				.mapToLong(l -> l * Lotto.PRICE)
				.sum();
	}

	private long getPrizeMoneySum() {
		return results.entrySet().stream()
				.mapToLong(r -> r.getKey().getPrizeMoney() * r.getValue())
				.sum();
	}
}
