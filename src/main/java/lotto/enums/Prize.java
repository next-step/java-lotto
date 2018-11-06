package lotto.enums;

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

	public static Prize get(int matchCount) {
		for(Prize prize : Prize.values()) {
			if(prize.matchCount == matchCount) {
				return prize;
			}
		}

		throw new IllegalArgumentException("일치하는 상금이 존재하지 않습니다.");
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getMoney() {
		return money;
	}
}
