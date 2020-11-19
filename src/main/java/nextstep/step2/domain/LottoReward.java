package nextstep.step2.domain;

import java.util.stream.Stream;

public enum LottoReward {
	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000),
	LOST(0, 0); //2개 이하로 맞으면 0원

	private final int countOfMatch;
	private final int winningMoney;

	LottoReward(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static LottoReward getReword(int countOfMatch) {
		return Stream.of(values())
				.filter(reward -> reward.countOfMatch == countOfMatch)
				.findFirst()
				.orElse(LOST);
	}
}
