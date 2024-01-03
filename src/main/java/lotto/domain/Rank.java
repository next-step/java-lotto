package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public enum Rank {
	PRIZE_COUNT(0, 0, 5),
	BONUS(0, 1, 0),
	RANK1(1, 6, 2000000000),
	RANK2(2, 5, 30000000),
	RANK3(3, 5, 1500000),
	RANK4(4, 4, 50000),
	RANK5(5, 3, 5000);

	private final Integer rank;
	private final Integer match;
	private final Integer prize;

	Rank(final Integer rank, final Integer match, final int prize) {
		this.rank = rank;
		this.match = match;
		this.prize = prize;
	}

	public static List<Integer> calculate(final List<MatchingNumbers> matchingNumbersList) {
		List<Integer> statistics = new ArrayList<>(Collections.nCopies(PRIZE_COUNT.prize + 1, 0));

		for (MatchingNumbers matchingNumbers : matchingNumbersList) {
			int count = 0;
			for (int rank = RANK1.rank; rank <= RANK5.rank; rank++) {
				if (rank == findRank(matchingNumbers)) {
					statistics.set(rank, ++count);
				}
			}
		}

		return statistics;
	}

	private static int findRank(final MatchingNumbers matchingNumbers) {
		for (Rank rank : Rank.values()) {
			Integer rank1 = matchRanking(matchingNumbers, rank);
			if (rank1 != null)
				return rank1;
		}

		return 0;
	}

	private static Integer matchRanking(final MatchingNumbers matchingNumbers, final Rank rank) {
		if (matchingNumbers.isMatching(rank.match)
			&& Objects.equals(matchingNumbers.isBonus(rank.rank), BONUS.match)) {
			return rank.rank;
		}
		if (matchingNumbers.isMatching(rank.match) && !Objects.equals(rank.rank, RANK2.rank)) {
			return rank.rank;
		}

		return null;
	}

	public static float calculateRateOfReturn(final List<Integer> rankCount, final int price) {
		int prizeMoney = 0;

		for (Rank rank : Rank.values()) {
			for (int i = 1; i <= rankCount.size(); i++) {
				if (i == rank.rank) {
					prizeMoney += rank.prize * rankCount.get(i);
				}
			}
		}

		return (float)prizeMoney / price;
	}
}
