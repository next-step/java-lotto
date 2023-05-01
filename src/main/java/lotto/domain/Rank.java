package lotto.domain;

import java.util.Arrays;

public enum Rank {

	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);

	private static final int MINIMUM_MATCH_COUNT_TO_WIN = 3;
	private static final int POSSIBLE_BONUS_MATCH_COUNT = 5;

	private final int matchCount;
	private final WinningMoney winningMoney;

	Rank(int matchCount, long winningMoney) {
		this.matchCount = matchCount;
		this.winningMoney = new WinningMoney(winningMoney);
	}

	public boolean isWinningRank() {
		return this.matchCount >= Rank.MINIMUM_MATCH_COUNT_TO_WIN;
	}

	public int getMatchCount() {
		return this.matchCount;
	}

	public long getWinningMoney() {
		return this.winningMoney.getWinningMoney();
	}

	public static Rank of(int matchCount, boolean matchBonus) {
		if (matchCount < Rank.MINIMUM_MATCH_COUNT_TO_WIN) {
			return Rank.MISS;
		}

		if (matchCount == Rank.POSSIBLE_BONUS_MATCH_COUNT) {
			return matchBonus ? Rank.SECOND : Rank.THIRD;
		}

		return Arrays.stream(values()).filter(e -> e.matchCount == matchCount).findAny().orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상금 타입입니다."));
	}
}
