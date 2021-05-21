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

	public HashMap<Rank, Integer> getStatMap() {
		return statMap;
	}

	public double calculateProfitRate() {
		long sumWinAmount = 0;
		Iterator<Rank> rankIterator = statMap.keySet().iterator();
		while (rankIterator.hasNext()) {
			Rank rank = rankIterator.next();
			sumWinAmount += rank.winningMoney * statMap.get(rank);
		}
		if (sumWinAmount == 0) {
			return 0;
		}
		return (double) sumWinAmount / this.totalPurchases;
	}
}
