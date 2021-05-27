package kht2199;

/**
 *
 * @author heetaek.kim
 */
public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);

	private final int countOfMatch;

	private final int winningMoney;

	Rank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static Rank valueOf(int countOfMatch, boolean matchBonus) {
		if (countOfMatch == 5 && matchBonus) {
			return SECOND;
		}
		if (countOfMatch == 5) {
			return THIRD;
		}
		for (Rank value : values()) {
			if (value.countOfMatch == countOfMatch) {
				return value;
			}
		}
		return MISS;
	}

}
