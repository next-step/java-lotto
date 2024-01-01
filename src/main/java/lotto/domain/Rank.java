package lotto.domain;

import java.util.List;

public enum Rank {
	PRIZE_COUNT(0, 0, 5),
	RANK5(5, 3, 5000),
	RANK4(4, 4, 50000),
	RANK3(3, 5, 1500000),
	RANK2(2, 5, 30000000),
	RANK1(1, 6, 2000000000);

	private final Integer rank;
	private final Integer match;
	private final Integer prize;

	Rank(Integer rank, Integer match, int prize) {
		this.rank = rank;
		this.match = match;
		this.prize = prize;
	}

	public static int[] calculate(final List<MatchingNumbers> matchingNumbersList) {
		int[] statistics = new int[PRIZE_COUNT.prize + 1];

		for (MatchingNumbers matchingNumbers : matchingNumbersList) {
			for (int rank = RANK5.rank; rank >= RANK1.rank; rank--) {
				if (rank == findPrize(matchingNumbers)) {
					++statistics[rank];
				}
			}
		}

		return statistics;
	}

	private static int findPrize(final MatchingNumbers matchingNumbers) {
		if (matchingNumbers.isMatching(RANK5.match)) {
			return RANK5.rank;
		}
		if (matchingNumbers.isMatching(RANK4.match)) {
			return RANK4.rank;
		}
		if (matchingNumbers.isMatching(RANK3.match) && matchingNumbers.isBonus()) {
			return RANK2.rank;
		}
		if (matchingNumbers.isMatching(RANK2.match)) {
			return RANK3.rank;
		}
		if (matchingNumbers.isMatching(RANK1.match)) {
			return RANK1.rank;
		}

		return 0;
	}

	public static float calculateRateOfReturn(int[] rankCount, final int price) {
		int prizeMoney = 0;

		for (int i = 1; i <= rankCount.length; i++) {
			if (i == RANK5.rank) {
				prizeMoney += RANK5.prize * rankCount[i];
			}
			if (i == RANK4.rank) {
				prizeMoney += RANK4.prize * rankCount[i];
			}
			if (i == RANK3.rank) {
				prizeMoney += RANK3.prize * rankCount[i];
			}
			if (i == RANK2.rank) {
				prizeMoney += RANK2.prize * rankCount[i];
			}
			if (i == RANK1.rank) {
				prizeMoney += RANK1.prize * rankCount[i];
			}
		}

		return (float)prizeMoney / price;
	}
}
