package lotto.domain;

import lotto.model.LOTTO_PRIZE_POLICY;

import java.util.List;

public class LottoResult {
	private int totalPrizeMoney = 0;

	private double earningsRate = 0.0;

	public double getEarningsRate() {
		return earningsRate;
	}

	public int getTotalPrizeMoney() {
		return totalPrizeMoney;
	}

	public void arrangePrize(List<Integer> lottoMatchCountResult, int lottoPricePerSheet) {
		for (Integer matchCount : lottoMatchCountResult) {
			this.totalPrizeMoney += calculateLottoPrize(matchCount);
		}
		this.earningsRate = (double) totalPrizeMoney / (lottoMatchCountResult.size() * lottoPricePerSheet);
	}

	private int calculateLottoPrize(int matchCount) {
		return LOTTO_PRIZE_POLICY.getPrizeMoney(matchCount);
	}

}