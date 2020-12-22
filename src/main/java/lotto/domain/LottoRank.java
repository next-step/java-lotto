package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000),
	MISS(0, 0);

	private final int countOfMatch;
	private final int winningMoney;

	LottoRank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static LottoRank valueOfCount(int countOfMatch) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.getCountOfMatch() == countOfMatch)
			.findFirst().orElse(LottoRank.MISS);
	}
}
