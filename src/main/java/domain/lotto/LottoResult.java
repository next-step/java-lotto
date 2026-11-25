package domain.lotto;

import java.util.List;

public class LottoResult {

	private final List<Rank> ranks;

	public LottoResult(List<Rank> ranks) {
		this.ranks = ranks;
	}

	public double profitRate(int money) {
		double rate = (double) totalPrize() / money;
		return Math.floor(rate * 100) / 100;
	}

	private long totalPrize() {
		long total = 0;
		for (Rank rank : ranks) {
			total += rank.getPrize();
		}
		return total;
	}
}
