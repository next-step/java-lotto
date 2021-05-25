package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {

	private final List<Rank> resultRanks;
	private final List<Rank> renderRanks;

	public LottoResults() {
		this.resultRanks = new ArrayList<>();
		this.renderRanks = Arrays.stream(Rank.values())
				.filter(rank -> rank.isGreaterThan(Rank.NONE))
				.sorted(Comparator.comparingInt(Rank::getMatchCount))
				.collect(Collectors.toList());
	}

	public void add(Rank rank) {
		this.resultRanks.add(rank);
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
		return this.resultRanks.size() * PurchaseAmount.MINIMUM;
	}

	public int findRankCount(Rank rank) {
		return this.resultRanks.stream()
				.filter(r -> r.equals(rank))
				.mapToInt(m -> 1)
				.sum();
	}

}
