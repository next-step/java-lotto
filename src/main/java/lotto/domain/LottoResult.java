package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoResult {

	private final List<LottoNumbers> lottos;
	private final LottoNumbers winLottoNumbers;
	private final int totalPurchases;
	private final HashMap<Rank, Integer> statMap;

	public LottoResult(List<LottoNumbers> lottos, LottoNumbers winLottoNumbers) {
		this.lottos = lottos;
		this.winLottoNumbers = winLottoNumbers;
		this.totalPurchases = lottos.size() * LottoGame.PURCHASE_AMOUNT_PER_LOTTO;
		this.statMap = initRankMap();
		this.findWinningResult();
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

	private void findWinningResult() {
		for (LottoNumbers lottoNumbers : lottos) {
			Rank rank = lottoNumbers.findRank(winLottoNumbers);
			addRank(rank);
		}
	}

	private void addRank(Rank rank) {
		this.statMap.put(rank, this.statMap.get(rank) + 1);
	}

	private HashMap<Rank, Integer> initRankMap() {
		HashMap<Rank, Integer> rankMap = new LinkedHashMap<>();
		rankMap.put(Rank.NONE, 0);
		rankMap.put(Rank.FOURTH, 0);
		rankMap.put(Rank.THIRD, 0);
		rankMap.put(Rank.SECOND, 0);
		rankMap.put(Rank.FIRST, 0);
		return rankMap;
	}
}
