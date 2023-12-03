package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Ranking {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	NOT_RANKED(0, 0);
	private final int matchingCount;
	private final int profit;

	Ranking(int matchingCount, int profit) {
		this.matchingCount = matchingCount;
		this.profit = profit;
	}

	public int matchingCount() {
		return matchingCount;
	}

	public int profit() {
		return profit;
	}

	public static List<Ranking> ranked() {
		return Stream.of(values()).filter(rank -> rank != Ranking.NOT_RANKED).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

	public static Ranking of(int matchingCount, boolean hasBonusNumber) {
		return Arrays.stream(values())
				.filter(ranking -> ranking.matchingCount == matchingCount)
				.filter(ranking -> ranking != Ranking.SECOND || hasBonusNumber)
				.findFirst()
				.orElse(Ranking.NOT_RANKED);
	}

}
