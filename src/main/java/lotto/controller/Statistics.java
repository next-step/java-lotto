package lotto.controller;

public final class Statistics {
	private static final int PRIZE_COUNT = 4;
	private static final int MATCH_COUNT_MIN = 3;
	private static final int MATCH_COUNT_MAX = 6;
	private static final int MATCH_3 = 0;
	private static final int MATCH_4 = 1;
	private static final int MATCH_5 = 2;
	private static final int MATCH_6 = 3;

	public static int[] calculate(final int[] numbersOfMatch) {
		int[] statistics = new int[PRIZE_COUNT];
		int num = 0;
		for (int i = MATCH_COUNT_MIN; i <= MATCH_COUNT_MAX; i++) {
			statistics[num] = findPrize(numbersOfMatch, i);
			num++;
		}

		return statistics;
	}

	private static int findPrize(final int[] numbersOfMatch, final int prize) {
		int count = 0;
		for (int i = 0; i < numbersOfMatch.length; i++) {
			if (numbersOfMatch[i] == prize) {
				count++;
			}
		}
		return count;
	}

	public static float calculateRateOfReturn(final int[] numbersOfMatch, final int price) {
		int prizeMoney = 0;
		for (int i = 0; i < numbersOfMatch.length; i++) {
			if (i == MATCH_3) {
				prizeMoney += 5000 * numbersOfMatch[i];
			}
			if (i == MATCH_4) {
				prizeMoney += 50000 * numbersOfMatch[i];
			}
			if (i == MATCH_5) {
				prizeMoney += 1500000 * numbersOfMatch[i];
			}
			if (i == MATCH_6) {
				prizeMoney += 2000000000 * numbersOfMatch[i];
			}
		}

		return (float)prizeMoney / price;
	}
}
