package automaticLotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Ranking {
	RANKING_LAST(0, 0), RANKING_5(3, 5000), RANKING_4(4, 500000), RANKING_3(5, 1500000), RANKING_2(5,
		30000000), RANKING_1(6, 2000000000);

	private static final Map<Integer, Ranking> rankingTable;
	public static final int SECOND_RANKING_MATCH_COUNT = 5;

	private final int matchedCount;
	private final int winnerPrice;

	static {
		rankingTable = new HashMap<>();
		for (Ranking ranking : values()) {
			rankingTable.put(ranking.getMatchedCount(), ranking);
		}
	}

	Ranking(int matchedCount, int winnerPrice) {
		this.matchedCount = matchedCount;
		this.winnerPrice = winnerPrice;
	}

	public int getMatchedCount() {
		return this.matchedCount;
	}

	public int getWinnerPrice() {
		return this.winnerPrice;
	}

	public static Ranking valueOf(int matchedCount, boolean isBonusNumberContained) {
		if (matchedCount == SECOND_RANKING_MATCH_COUNT && isBonusNumberContained) {
			return RANKING_2;
		}

		if (matchedCount == SECOND_RANKING_MATCH_COUNT) {
			return RANKING_3;
		}

		if (rankingTable.containsKey(matchedCount)) {
			return rankingTable.get(matchedCount);
		}

		return Ranking.RANKING_LAST;
	}

	public static String getExplanation(Ranking ranking) {
		if (ranking == Ranking.RANKING_2) {
			return ranking.getMatchedCount() + "개 일치, 보너스볼 일치";
		}

		return ranking.getMatchedCount() + "개 일치";
	}
}
