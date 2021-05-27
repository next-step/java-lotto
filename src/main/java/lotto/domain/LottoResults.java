package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResults {

	public static final int RANK_RESULT_DEFAULT_VALUE = 0;
	public static final int ADD_RANK_COUNT = 1;

	private final Map<Rank, Integer> rankResults;

	public LottoResults(List<Rank> ranks) {
		rankResults = new HashMap<>();
		for (Rank rank : ranks) {
			int rankCount = rankResults.getOrDefault(rank, RANK_RESULT_DEFAULT_VALUE) + ADD_RANK_COUNT;
			rankResults.put(rank, rankCount);
		}
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
		return findPurchaseCount() * PurchaseAmount.AMOUNT_PER_UNIT;
	}

	private int findPurchaseCount() {
		Set<Rank> ranks = rankResults.keySet();
		return ranks.stream()
				.mapToInt(rank -> rankResults.getOrDefault(rank, RANK_RESULT_DEFAULT_VALUE))
				.sum();
	}

	public int findRankCount(Rank rank) {
		return rankResults.getOrDefault(rank, RANK_RESULT_DEFAULT_VALUE);
	}

}
