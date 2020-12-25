package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoResult {
	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000),
	NONE(0, 2, 0);

	private final int minSameNumberCount;
	private final int maxSameNumberCount;
	private final Money money;

	LottoResult(int sameNumberCount, int money) {
		this(sameNumberCount, sameNumberCount, money);
	}

	LottoResult(int minSameNumberCount, int maxSameNumberCount, int money) {
		this.minSameNumberCount = minSameNumberCount;
		this.maxSameNumberCount = maxSameNumberCount;
		this.money = Money.of(money);
	}

	public static LottoResult of(int sameNumberCount) {
		return Arrays.stream(values())
			.filter(containsNumberCount(sameNumberCount))
			.findFirst()
			.orElse(NONE);
	}

	private static Predicate<LottoResult> containsNumberCount(int sameNumberCount) {
		return value -> value.minSameNumberCount <= sameNumberCount
			&& sameNumberCount <= value.maxSameNumberCount;
	}

	public Money getMoney() {
		return money;
	}
}
