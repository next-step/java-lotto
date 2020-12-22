package lotto.domain;

import lotto.model.LottoPrizePolicy;

import java.util.List;

public class LottoResult {

	private int totalPrizeMoney = 0;

	private double earningsRate = 0.0;

	//어떤 기능이 있는지 빠르게 파악할 수 있도록 public 주요 메서드를 상단에 배치
	public void arrangePrize(List<LottoMatchResult> lottoMatchCountResult, int lottoPricePerSheet) {
		this.totalPrizeMoney = 0;
		for (LottoMatchResult lottoResult : lottoMatchCountResult) {
			this.totalPrizeMoney = calculateLottoPrize(lottoResult,this.totalPrizeMoney);
		}
		earningsRate = (double) this.totalPrizeMoney / (lottoMatchCountResult.size() * lottoPricePerSheet);
	}

	private int calculateLottoPrize(LottoMatchResult lottoMatchResult, int totalPrizeMoney) {
		return LottoPrizePolicy.getPrizeMoney(lottoMatchResult, totalPrizeMoney);
	}

	public double getEarningsRate() {
		return earningsRate;
	}

	public int getTotalPrizeMoney() {
		return totalPrizeMoney;
	}
}