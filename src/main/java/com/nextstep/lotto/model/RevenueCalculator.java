package com.nextstep.lotto.model;

import java.util.Arrays;

public enum RevenueCalculator {
	NO_MATCH(0, 0),
	THREE_MATCH(3, 5000),
	FOUR_MATCH(4, 50000),
	FIVE_MATCH(5, 1500000),
	SIX_MATCH(6, 2000000000);

	private int matchCount;
	private int revenue;

	RevenueCalculator(int matchCount, int revenue) {
		this.matchCount = matchCount;
		this.revenue = revenue;
	}

	public int getRevenue() {
		return revenue;
	}

	public static RevenueCalculator valueOf(int matchCount) {
		return Arrays.stream(RevenueCalculator.values())
			.filter(c -> c.matchCount == matchCount)
			.findAny()
			.orElse(NO_MATCH);
	}
}
