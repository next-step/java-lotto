package automaticLotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankingTable {
	private static final Map<Integer, Integer> rankingTable;
	private static final int NOTHING = 0;

	static {
		rankingTable = new HashMap<>();
		rankingTable.put(3, 5000);
		rankingTable.put(4, 500000);
		rankingTable.put(5, 1500000);
		rankingTable.put(6, 2000000000);
	}

	public static int getWinAmount(int matchedCount) {
		if (rankingTable.containsKey(matchedCount)) {
			return rankingTable.get(matchedCount);
		}

		return NOTHING;
	}

}
