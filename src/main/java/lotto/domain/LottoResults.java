package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResults {

	public static final int RANK_RESULT_DEFAULT_VALUE = 0;
	public static final int ADD_RANK_COUNT = 1;

	private final Map<Rank, Integer> rankResults;
	private final List<Rank> renderRanks;

	public LottoResults(List<Rank> ranks) {
		rankResults = new HashMap<>();
		for (Rank rank : ranks) {
			int rankCount = rankResults.getOrDefault(rank, RANK_RESULT_DEFAULT_VALUE) + ADD_RANK_COUNT;
			rankResults.put(rank, rankCount);
		}

		renderRanks = Arrays.stream(Rank.values())
				.filter(rank -> rank.isGreaterThan(Rank.NONE))
				.sorted(Comparator.comparing(Rank::getMatchCount).thenComparing(Rank::getWinningMoney))
				.collect(Collectors.toList());
	}

	public List<Rank> getRenderRanks() {
		return renderRanks;
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
		return getPurchaseCount() * PurchaseAmount.MINIMUM;
	}

	private int getPurchaseCount() {
		Set<Rank> ranks = rankResults.keySet();
		return ranks.stream()
				.mapToInt(rank -> rankResults.getOrDefault(rank, RANK_RESULT_DEFAULT_VALUE))
				.sum();
	}

	public int findRankCount(Rank rank) {
		return rankResults.getOrDefault(rank, RANK_RESULT_DEFAULT_VALUE);
	}

}
