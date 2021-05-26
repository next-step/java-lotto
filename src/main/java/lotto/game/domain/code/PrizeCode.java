package lotto.game.domain.code;

public enum PrizeCode {
	NOTHING(6, 0, 0),
	FIFTH_PLACE(5, 3, 5000),
	FOURTH_PLACE(4, 4, 50000),
	THIRD_PLACE(3, 5, 1500000),
	// SECOND_PLACE(2, 5, 20000000),
	WINNER(1, 6, 2000000000);

	private int grade;
	private int countOfMatch;
	private int winningAmount;

	PrizeCode(int grade, int countOfMatch, int winningAmount) {
		this.grade = grade;
		this.countOfMatch = countOfMatch;
		this.winningAmount = winningAmount;
	}

	public static PrizeCode findCode(int countOfMatch) {
		if (WINNER.countOfMatch() == countOfMatch) {
			return WINNER;
		}
		if (THIRD_PLACE.countOfMatch() == countOfMatch) {
			return THIRD_PLACE;
		}
		if (FOURTH_PLACE.countOfMatch() == countOfMatch) {
			return FOURTH_PLACE;
		}
		if (FIFTH_PLACE.countOfMatch() == countOfMatch) {
			return FIFTH_PLACE;
		}
		return NOTHING;
	}

	public int countOfMatch() {
		return this.countOfMatch;
	}

	public int grade() {
		return this.grade;
	}

	public int winningAmount() {
		return this.winningAmount;
	}

	public boolean isFifthPlace() {
		return this == FIFTH_PLACE;
	}

	public boolean isFourthPlace() {
		return this == FOURTH_PLACE;
	}

	public boolean isThirdPlace() {
		return this == THIRD_PLACE;
	}

	// public boolean isSecondPlace() {
	// 	return this == SECOND_PLACE;
	// }

	public boolean isWinner() {
		return this == WINNER;
	}

	public boolean isNothing() {
		return this == NOTHING;
	}
}
