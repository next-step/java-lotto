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
}
