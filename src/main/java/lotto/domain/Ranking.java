package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Ranking {
	RANKING_LAST(new RankingCondition(0), 0),
	RANKING_5(new RankingCondition(3), 5000),
	RANKING_4(new RankingCondition(4), 500000),
	RANKING_3(new RankingCondition(5, false), 1500000),
	RANKING_2(new RankingCondition(5, true), 30000000),
	RANKING_1(new RankingCondition(6), 2000000000);

	private static final Map<RankingCondition, Ranking> rankingTable;

	private final RankingCondition rankingCondition;
	private final int winnerPrice;

	static {
		rankingTable = new HashMap<>();
		for (Ranking ranking : values()) {
			rankingTable.put(ranking.rankingCondition, ranking);
		}
	}

	Ranking(RankingCondition rankingCondition, int winnerPrice) {
		this.rankingCondition = rankingCondition;
		this.winnerPrice = winnerPrice;
	}

	public RankingCondition getRankingCondition() {
		return this.rankingCondition;
	}

	public int getWinnerPrice() {
		return this.winnerPrice;
	}

	public static Ranking valueOf(RankingCondition rankingCondition) {
		if (rankingTable.containsKey(rankingCondition)) {
			return rankingTable.get(rankingCondition);
		}

		return Ranking.RANKING_LAST;
	}

	public static String getExplanation(Ranking ranking) {
		if (ranking == Ranking.RANKING_2) {
			return ranking.getRankingCondition().getMatchedCount() + "개 일치, 보너스볼 일치";
		}

		return ranking.getRankingCondition().getMatchedCount() + "개 일치";
	}
}
