package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {

	private final List<LottoResult> lottoResults;

	public LottoResults() {
		this.lottoResults = new ArrayList<>();
	}

	public void add(LottoResult lottoResult) {
		this.lottoResults.add(lottoResult);
	}

	public double calculateProfitRate() {
		long sumWinAmount = 0;
		for (Rank rank : Rank.values()) {
			int rankCount = findRankCount(rank);
			sumWinAmount += rank.multiplyWinningMoney(rankCount);
		}
		if (sumWinAmount == 0) {
			return 0;
		}
		return (double) sumWinAmount / totalPurchaseAmount();
	}

	private double totalPurchaseAmount() {
		return lottoResults.size() * PuchaseAmount.MINIMUM;
	}

	public int findRankCount(Rank rank) {
		int rankCount = this.lottoResults.stream()
				.filter(lottoResult -> lottoResult.getRank().equals(rank))
				.mapToInt(m -> 1)
				.sum();
		return rankCount;
	}

}
