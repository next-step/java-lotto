package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public enum Rank {
	WINNER(6, 2_000_000_000),
	SECOND(5, 15_000_000),
	THIRD(4, 50_000),
	FOURTH(3, 5000),
	FIVE(0, 0);

	private final int matchesCount;
	private final int amountMoney;

	Rank(int matchesCount, int amountMoney) {
		this.matchesCount = matchesCount;
		this.amountMoney = amountMoney;
	}

	public static Rank ofMatchesCount(int matchesCount) {
		return Stream.of(values())
			.filter(target -> target.getMatchesCount() == matchesCount)
			.findFirst()
			.orElse(FIVE);
	}

	public static Stream<Rank> greaterThanCountZeroAndSortedAmount() {
		return Arrays.stream(values())
			.sorted(Comparator.comparingInt(Rank::getMatchesCount))
			.filter(target -> target.getAmountMoney() > 0);
	}

	public int getMatchesCount() {
		return matchesCount;
	}

	public int getAmountMoney() {
		return amountMoney;
	}
}
