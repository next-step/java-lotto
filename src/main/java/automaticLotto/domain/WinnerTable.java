package automaticLotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinnerTable {
	private static final int NOTHING = 0;

	Map<Integer, Integer> winnerTable;

	public WinnerTable() {
		this.winnerTable = new HashMap<>();
		initiateWinnerTable();
	}

	private void initiateWinnerTable() {
		for (int i = Ranking.RANKING_4.getMatchedCount(); i <= Ranking.RANKING_1.getMatchedCount(); i++) {
			winnerTable.put(i, NOTHING);
		}
	}

	public Map<Integer, Integer> getWinnerTable() {
		return this.winnerTable;
	}

	public int getWinnerCount(int matchedCount) {
		if (hasCount(matchedCount)) {
			return winnerTable.get(matchedCount);
		}

		return NOTHING;
	}

	public double getTotalAmount() {
		double totalAmount = 0.00;

		for (Integer matchedCount : winnerTable.keySet()) {
			totalAmount += getWinnerCount(matchedCount) * RankingTable.getWinnerPrice(matchedCount);
		}

		return totalAmount;
	}

	public void count(int matchedCount) {
		int count;

		if (hasCount(matchedCount)) {
			count = winnerTable.get(matchedCount);
			winnerTable.replace(matchedCount, ++count);
		}
	}

	private boolean hasCount(int matchedNumber) {
		return winnerTable.containsKey(matchedNumber);
	}
}
