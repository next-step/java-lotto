package lotto.controller;

public enum Statistics {
	PRIZE_COUNT(4),
	MATCH_COUNT_MIN(3),
	MATCH_COUNT_MAX(6),
	MATCH_3(0),
	MATCH_4(1),
	MATCH_5(2),
	MATCH_6(3);

	private final Integer value;

	Statistics(Integer value) {
		this.value = value;
	}

	public static int[] calculate(final int[] numbersOfMatch) {
		int[] statistics = new int[PRIZE_COUNT.value];
		int num = 0;

		for (int i = MATCH_COUNT_MIN.value; i <= MATCH_COUNT_MAX.value; i++) {
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
			if (i == MATCH_3.value) {
				prizeMoney += 5000 * numbersOfMatch[i];
			}
			if (i == MATCH_4.value) {
				prizeMoney += 50000 * numbersOfMatch[i];
			}
			if (i == MATCH_5.value) {
				prizeMoney += 1500000 * numbersOfMatch[i];
			}
			if (i == MATCH_6.value) {
				prizeMoney += 2000000000 * numbersOfMatch[i];
			}
		}

		return (float)prizeMoney / price;
	}
}
