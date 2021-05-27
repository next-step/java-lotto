package ui;

import java.util.Objects;

public enum Rank {
	FIRST(6, 2000000000),
	SECOND(5, 1500000),
	THIRD(4, 50000),
	FIFTH(3, 5000);

	private final Integer money;
	private final Integer countOfMatch;

	Rank (Integer money, Integer countOfMatch) {
		this.money = money;
		this.countOfMatch = countOfMatch;
	}

	public Integer getMoney () {
		return money;
	}

	public Integer getCountOfMatch () { return countOfMatch; }

	public static Rank valueOf(Integer countOfMatch, Boolean matchBonus) {
		Rank[] ranks = values();
		for (Rank rank : ranks) {
			if (Objects.equals(rank.getCountOfMatch(), countOfMatch)) {
				return rank;
			}
		}
		return null;
	}
}
