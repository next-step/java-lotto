package lotto.enums;

import java.util.Arrays;

public enum Prize {

	MATCH6(6, 2000000000),
	MATCH5(5, 1500000),
	MATCH4(4, 50000),
	MATCH3(3, 5000),
	MATCH2(2, 0),
	MATCH1(1, 0),
	NO_MATCH(0, 0);

	private int matchCount;
	private int money;

	Prize(int matchCount, int money) {
		this.matchCount = matchCount;
		this.money = money;
	}

	public static Prize of(int matchCount) {
		return Arrays.stream(Prize.values())
				.filter(prize -> prize.isSameMatchCount(matchCount))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("일치하는 상금이 존재하지 않습니다."));
	}

	private boolean isSameMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getMoney() {
		return money;
	}
}
