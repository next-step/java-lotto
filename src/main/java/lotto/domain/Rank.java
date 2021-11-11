package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lotto.exception.RankMatchCountSizeException;

public enum Rank {
	MISS(0, 0),
	FORTH(3, 5_000),
	THIRD(4, 50_000),
	SECOND(5, 1_500_000),
	FIRST(6, 2_000_000_000);

	public static final int MIN_OF_MATCH = 0;
	public static final int MAX_OF_MATCH = 6;

	private static final Map<Integer, Rank> CACHED_RANK = Arrays.stream(values())
		.collect(Collectors.toMap(Rank::getCountOfMatch, Function.identity()));

	private final int countOfMatch;
	private final int winningMoney;

	Rank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public static Rank from(int countOfMatch) {
		validate(countOfMatch);
		return CACHED_RANK.getOrDefault(countOfMatch, MISS);
	}

	private static void validate(int countOfMatch) {
		if (countOfMatch < MIN_OF_MATCH || countOfMatch > MAX_OF_MATCH) {
			throw new RankMatchCountSizeException();
		}
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}
}
