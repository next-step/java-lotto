package com.nextstep.lotto.model;

import java.util.List;

public class RevenueRatio implements Printable{

	private int money;
	private List<LottoMatch> lottoMatches;

	public RevenueRatio(int money, List<LottoMatch> lottoMatches) {
		this.money = money;
		this.lottoMatches = lottoMatches;
	}

	public double calculate() {
		int totalRevenue = 0;
		for (LottoMatch lottoMatch : lottoMatches) {
			totalRevenue += RevenueCalculator.valueOf(lottoMatch.getMatchedCount()).getRevenue();
		}
		return totalRevenue / Double.valueOf(money);
	}

	@Override
	public void print() {
		System.out.println(String.format(REVENUE_RATIO_STRING, calculate()));
	}
}
