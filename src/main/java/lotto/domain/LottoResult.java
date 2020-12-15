package lotto.domain;

import java.util.List;

public class LottoResult {
	public static final int THREE_MATCH_PRIZE_MONEY = 5000;

	public static final int FOUR_MATCH_PRIZE_MONEY = 50000;

	public static final int FIVE_MATCH_PRIZE_MONEY = 1500000;

	public static final int SIX_MATCH_PRIZE_MONEY = 2000000000;


	private int threeMatchCount = 0;

	private int fourMatchCount = 0;

	private int fiveMatchCount = 0;

	private int sixMatchCount = 0;

	private int totalPrizeMoney = 0;

	private double earningsRate = 0.0;

	public int getThreeMatchCount() {
		return threeMatchCount;
	}

	public int getFourMatchCount() {
		return fourMatchCount;
	}

	public int getFiveMatchCount() {
		return fiveMatchCount;
	}

	public int getSixMatchCount() {
		return sixMatchCount;
	}

	public double getEarningsRate() {
		return earningsRate;
	}

	public void arrangePrize(List<Integer> lottoMatchCountResult, int lottoPricePerSheet) {
		for (Integer matchCount : lottoMatchCountResult) {
			calculateLottoPrize(matchCount);
		}
		earningsRate = (double) totalPrizeMoney / (lottoMatchCountResult.size() * lottoPricePerSheet);
	}

	private void calculateLottoPrize(Integer matchCount) {
		if (matchCount == 3) {
			threeMatchCount += 1;
			totalPrizeMoney += THREE_MATCH_PRIZE_MONEY;
		}
		if (matchCount == 4) {
			fourMatchCount += 1;
			totalPrizeMoney += FOUR_MATCH_PRIZE_MONEY;
		}
		if (matchCount == 5) {
			fiveMatchCount += 1;
			totalPrizeMoney += FIVE_MATCH_PRIZE_MONEY;
		}
		if (matchCount == 6) {
			sixMatchCount += 1;
			totalPrizeMoney += SIX_MATCH_PRIZE_MONEY;
		}
	}

}
