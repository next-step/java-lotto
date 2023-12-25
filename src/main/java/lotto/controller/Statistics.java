package lotto.controller;

public class Statistics {
	public static int[] calculate(int[] numbersOfMatch) {
		int[] statistics = new int[4];
		int num = 0;
		for (int i = 3; i < 7; i++) {
			statistics[num] = findPrize(numbersOfMatch, i);
			num++;
		}

		return statistics;
	}

	private static int findPrize(int[] numbersOfMatch, int prize) {
		int count = 0;
		for (int i = 0; i < numbersOfMatch.length; i++) {
			if (numbersOfMatch[i] == prize) {
				count++;
			}
		}
		return count;
	}

	public static float calculateRateOfReturn(int[] numbersOfMatch, int price) {
		int prizeMoney = 0;
		for (int i = 0; i < numbersOfMatch.length; i++) {
			if (i == 0) {
				prizeMoney += 5000 * numbersOfMatch[i];
			}
			if (i == 1) {
				prizeMoney += 50000 * numbersOfMatch[i];
			}
			if (i == 2) {
				prizeMoney += 1500000 * numbersOfMatch[i];
			}
			if (i == 3) {
				prizeMoney += 2000000000 * numbersOfMatch[i];
			}
		}
		return (float)prizeMoney / price;
	}
}
