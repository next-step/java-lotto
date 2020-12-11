package lotto;

import java.util.List;

public class LottoResults {

	private final List<LottoResult> lottoResults;

	public LottoResults(List<LottoResult> lottoResults) {
		this.lottoResults = lottoResults;
	}

	public int askCountOfRank(Rank rankType) {
		return (int) this.lottoResults.stream()
			.filter(lottoResult -> lottoResult.isMatchesRank(rankType))
			.count();
	}
}
