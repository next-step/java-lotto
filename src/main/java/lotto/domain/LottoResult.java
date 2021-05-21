package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;

public class LottoResult {

	private final int totalPurchases;
	private final HashMap<Rank, Integer> statMap;

	public LottoResult(int totalPurchases, HashMap<Rank, Integer> statMap) {
		this.totalPurchases = totalPurchases;
		this.statMap = statMap;
	}

	public int getTotalPurchases() {
		return totalPurchases;
	}

	public HashMap<Rank, Integer> getStatMap() {
		return statMap;
	}

	public float findPercentageOfRevenue() {
		long sumWinAmount = 0;
		Iterator<Rank> rankIterator = statMap.keySet().iterator();
		while (rankIterator.hasNext()) {
			Rank rank = rankIterator.next();
			sumWinAmount += rank.winningMoney * statMap.get(rank);
		}
		if (sumWinAmount == 0) {
			return 0;
		}
		return sumWinAmount / this.totalPurchases;
	}
}
