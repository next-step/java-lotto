package lotto.game.domain.code;

import java.util.Arrays;

public enum PrizeCode {
	NOTHING(0, false, 0),
	FIFTH_PLACE(3, false, 5_000),
	FOURTH_PLACE(4, false, 50_000),
	THIRD_PLACE(5, false, 1_500_000),
	SECOND_PLACE(5, true, 30_000_000),
	WINNER(6, false, 2_000_000_000);

	private static final int COUNT_OF_MATCH_THAT_NEEDS_TO_CHECK_IS_MATCH_BONUS_BALL = 5;

	private final int countOfMatch;
	private final boolean isMatchBonusBall;
	private final int winningAmount;

	PrizeCode(int countOfMatch, boolean isMatchBonusBall, int winningAmount) {
		this.countOfMatch = countOfMatch;
		this.isMatchBonusBall = isMatchBonusBall;
		this.winningAmount = winningAmount;
	}

	public static PrizeCode findCode(int countOfMatch) {
		return findCode(countOfMatch, false);
	}

	public static PrizeCode findCode(int countOfMatch, boolean isMatchBonusBall) {
		return Arrays.stream(values())
			.filter(prizeCode -> prizeCode.isSameCountOfMatchAndBonusBall(countOfMatch, isMatchBonusBall))
			.findFirst()
			.orElse(NOTHING);
	}

	private boolean isSameCountOfMatchAndBonusBall(int countOfMatch, boolean isMatchBonusBall) {
		if (countOfMatch == COUNT_OF_MATCH_THAT_NEEDS_TO_CHECK_IS_MATCH_BONUS_BALL) {
			return this.countOfMatch == countOfMatch && this.isMatchBonusBall == isMatchBonusBall;
		}
		return this.countOfMatch == countOfMatch;
	}

	public int countOfMatch() {
		return this.countOfMatch;
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

	public boolean isSecondPlace() {
		return this == SECOND_PLACE;
	}

	public boolean isWinner() {
		return this == WINNER;
	}

	public boolean isNothing() {
		return this == NOTHING;
	}
}
