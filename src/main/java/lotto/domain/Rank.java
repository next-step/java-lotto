package lotto.domain;

import java.util.Set;

public enum Rank {
	PRIZE_COUNT(0, 4),
	MATCH_COUNT_MIN(3, 0),
	MATCH_COUNT_MAX(6, 0),
	RANK4(0, 5000),
	RANK3(1, 50000),
	RANK2(2, 1500000),
	RANK1(3, 2000000000);

	private final Integer match;
	private final Integer prize;

	Rank(Integer match, int prize) {
		this.match = match;
		this.prize = prize;
	}

	public static int[] calculate(final int[] numbersOfMatch) {
		int[] statistics = new int[PRIZE_COUNT.prize];
		int num = 0;

		for (int i = MATCH_COUNT_MIN.match; i <= MATCH_COUNT_MAX.match; i++) {
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
			if (i == RANK4.match) {
				prizeMoney += RANK4.prize * numbersOfMatch[i];
			}
			if (i == RANK3.match) {
				prizeMoney += RANK3.prize * numbersOfMatch[i];
			}
			if (i == RANK2.match) {
				prizeMoney += RANK2.prize * numbersOfMatch[i];
			}
			if (i == RANK1.match) {
				prizeMoney += RANK1.prize * numbersOfMatch[i];
			}
		}

		return (float)prizeMoney / price;
	}

	public static int[] check(final Set<LottoNumber> winningNumbers, final Ticket ticket) {
		int[] numbersOfMatch = new int[ticket.ticket().size()];

		for (int i = 0; i < ticket.ticket().size(); i++) {
			numbersOfMatch[i] = ticket.compareTo(winningNumbers, i);
		}

		return numbersOfMatch;
	}
}
