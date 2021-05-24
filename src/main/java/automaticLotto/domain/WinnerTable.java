package automaticLotto.domain;

import java.util.Map;

public class WinnerTable {
	private static final int NOTHING = 0;

	Map<Integer, Integer> winnerTable;

	public WinnerTable(Map<Integer, Integer> winnerTable) {
		this.winnerTable = winnerTable;
	}

	public Map<Integer, Integer> getWinnerTable() {
		return this.winnerTable;
	}

	public int getWinnerCount(int matchedCount) {
		if (winnerTable.containsKey(matchedCount)) {
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
}
