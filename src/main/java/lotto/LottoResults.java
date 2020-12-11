package lotto;

import java.util.List;

public class LottoResults {

	private final List<LottoResult> results;

	public LottoResults(List<LottoResult> results) {
		this.results = results;
	}

	public int askCountOfRank(Rank rankType) {
		return Math.toIntExact(this.results.stream()
			.filter(result -> result.isMatchesRank(rankType))
			.count());
	}
}
