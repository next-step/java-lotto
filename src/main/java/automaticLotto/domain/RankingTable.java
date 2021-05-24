package automaticLotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankingTable {
	private static final Map<Integer, Integer> rankingTable;
	private static final int NOTHING = 0;

	static {
		rankingTable = new HashMap<>();

		for (Ranking ranking : Ranking.values()) {
			rankingTable.put(ranking.getMatchedCount(), ranking.getwinnerPrice());
		}
	}

	public static int getWinnerPrice(int matchedCount) {
		if (rankingTable.containsKey(matchedCount)) {
			return rankingTable.get(matchedCount);
		}

		return NOTHING;
	}
}
