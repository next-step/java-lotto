package ui;

public enum Rank {
	FIRST(6, 2000000000),
	SECOND_BONUS(5, 30000000),
	SECOND(5, 1500000),
	THIRD(4, 50000),
	FIFTH(3, 5000),
	NONE(0, 0),
	NOT_YET(null, null);

	private final Integer countOfMatch;
	private final Integer money;

	Rank (Integer countOfMatch, Integer money) {
		this.countOfMatch = countOfMatch;
		this.money = money;
	}

	public static Rank valueOf (Integer countOfMatch) {
		Rank[] ranks = values();
		for (Rank rank : ranks) {
			if (rank.countOfMatch() == countOfMatch) {
				return rank;
			}
		}
		return Rank.NONE;
	}

	public Integer money () {
		return money;
	}

	public Integer countOfMatch () {
		return countOfMatch;
	}
}