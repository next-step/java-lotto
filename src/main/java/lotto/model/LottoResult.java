package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

	private int totalWinningMoney;
	private double returnRate;
	private final Map<LottoRank, Integer> win;

	public LottoResult(int totalWinningMoney, double returnRate) {
		this.totalWinningMoney = totalWinningMoney;
		this.returnRate = returnRate;
		this.win = new HashMap<>();
	}

	public void addRank(LottoRank lottoRank) {
		if (win.get(lottoRank) == null) {
			win.put(lottoRank, 1);
			return;
		}
		win.put(lottoRank, win.get(lottoRank) + 1);
	}

	public void calculateTotalWinningMoney() {
		for (Map.Entry<LottoRank, Integer> entry : win.entrySet()) {
			totalWinningMoney += entry.getKey().money() * entry.getValue();
		}
	}

	public Map<LottoRank, Integer> totalWinningStatistics() {
		return this.win;
	}

	public void calculateReturnRate(int totalPayMoney) {
		this.returnRate = Math.round((double) totalWinningMoney / (double) totalPayMoney * 100.0) / 100.0;
	}

	public double returnRate() {
		return this.returnRate;
	}
}
