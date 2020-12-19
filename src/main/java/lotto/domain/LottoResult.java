package lotto.domain;

import lotto.model.LottoPrizePolicy;

import java.util.List;

public class LottoResult {
	private int totalPrizeMoney = 0;

	private double earningsRate = 0.0;

	//어떤 기능이 있는지 빠르게 파악할 수 있도록 public 주요 메서드를 상단에 배치
	public void arrangePrize(List<Integer> lottoMatchCountResult, int lottoPricePerSheet) {
		for (int matchCount : lottoMatchCountResult) {
			totalPrizeMoney += calculateLottoPrize(matchCount);
		}
		earningsRate = (double) totalPrizeMoney / (lottoMatchCountResult.size() * lottoPricePerSheet);
	}

	private int calculateLottoPrize(int matchCount) {
		return LottoPrizePolicy.getPrizeMoney(matchCount);
	}

	public double getEarningsRate() {
		return earningsRate;
	}

	public int getTotalPrizeMoney() {
		return totalPrizeMoney;
	}
}