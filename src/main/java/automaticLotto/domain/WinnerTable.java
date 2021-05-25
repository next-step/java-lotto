package automaticLotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinnerTable {
	private static final int NOTHING = 0;

	Map<Ranking, Integer> winnerTable;

	public WinnerTable() {
		this.winnerTable = new HashMap<>();
		initiateWinnerTable();
	}

	private void initiateWinnerTable() {
		for (Ranking ranking : Ranking.values()) {
			winnerTable.put(ranking, NOTHING);
		}
	}

	public Map<Ranking, Integer> getWinnerTable() {
		return this.winnerTable;
	}

	public int getWinnerCount(Ranking winner) {
		if (hasCount(winner)) {
			return winnerTable.get(winner);
		}

		return NOTHING;
	}

	public double getTotalAmount() {
		double totalAmount = 0.00;

		for (Ranking winner : winnerTable.keySet()) {
			totalAmount += getWinnerCount(winner) * winner.getWinnerPrice();
		}

		return totalAmount;
	}

	public void count(Ranking ranking) {
		int count;

		if (hasCount(ranking)) {
			count = winnerTable.get(ranking);
			winnerTable.replace(ranking, ++count);
		}
	}

	private boolean hasCount(Ranking ranking) {
		return winnerTable.containsKey(ranking);
	}
}
