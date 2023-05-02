package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankBoard {

	private final Map<Rank, Integer> rankBoard = new HashMap<>();

	public RankBoard(List<Lotto> purchasedLottos) {
		for (Rank rank : Rank.values()) {
			this.rankBoard.put(rank, 0);
		}
		for (Lotto purchasedLotto : purchasedLottos) {
			Rank rank = purchasedLotto.rank();
			this.plusCount(purchasedLotto, rank);
		}
	}

	private void plusCount(Lotto purchasedLotto, Rank rank) {
		if (this.rankBoard.containsKey(purchasedLotto.rank())) {
			this.rankBoard.put(rank, (rankBoard.get(rank) + 1));
		}
	}

	public List<RankSituation> makeRankSituations() {
		return this.rankBoard.entrySet().stream()
			.filter(e -> e.getKey().isWinningRank())
			.map(e -> new RankSituation(e.getKey(), e.getValue()))
			.collect(Collectors.toList());
	}

	public Integer winCount(Rank rank) {
		return this.rankBoard.get(rank);
	}
}
