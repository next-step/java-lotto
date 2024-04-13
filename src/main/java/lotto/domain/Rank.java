package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	INVALID(0, 0);
	private int matchCount;
	private int prize;

	Rank(int matchCount, int prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}

	public static Rank from(int matchCount, boolean isBonus) {
		return Arrays.stream(Rank.values())
			.filter(rank -> rank.isSameMatchCount(matchCount))
			.filter(rank -> checkBonus(matchCount, isBonus, rank))
			.findFirst()
			.orElse(INVALID);
	}

	private static boolean checkBonus(int matchCount, boolean isBonus, Rank rank) {
		return (matchCount == 5 && isBonus) || rank != SECOND;
	}

	private boolean isSameMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	public int countSameMatch(List<Rank> ranks) {
		return (int)ranks.stream()
			.filter(rank -> rank == this)
			.count();
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrize() {
		return prize;
	}
}
