package lotto.enums;

import java.util.Arrays;

public enum Prize {

	FIRST(6, 2000000000),
	SECOND(5, 1500000),
	THIRD(5, 50000),
	FOURTH(4, 5000),
	FIFTH(3, 0),
	NO_MATCH(0, 0);

	private int matchCount;
	private int money;

	Prize(int matchCount, int money) {
		this.matchCount = matchCount;
		this.money = money;
	}

	public static Prize of(int matchCount, boolean hasBonusNumber) {
		return Arrays.stream(Prize.values())
				.filter(prize -> prize.isSameMatchCount(matchCount))
				.filter(prize -> !prize.equals(SECOND) || hasBonusNumber) // 2등 확인 로직
				.findFirst()
				.orElse(NO_MATCH);
	}

	private boolean isSameMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	public int sumMoney(int totalMoney) {
		return money + totalMoney;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getMoney() {
		return money;
	}
}
