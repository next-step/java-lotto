package com.nextstep.lotto.model;

import java.util.List;

public class RevenueRatio {

	private int money;
	private List<LottoResult> lottoResults;

	public RevenueRatio(int money, List<LottoResult> lottoResults) {
		this.money = money;
		this.lottoResults = lottoResults;
	}

	public double calculate() {
		int totalRevenue = 0;
		for (LottoResult lottoResult : lottoResults) {
			totalRevenue += RevenueCalculator.valueOf(lottoResult.getMatchedCount()).getRevenue();
		}
		return totalRevenue / Double.valueOf(money);
	}
}
