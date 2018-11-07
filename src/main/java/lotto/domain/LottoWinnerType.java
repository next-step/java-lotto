package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hspark on 06/11/2018.
 */
public enum LottoWinnerType {
	FIRST_WINNER(6, false, 2_000_000_000),
	SECOND_WINNER(5, true, 30_000_000),
	THIRD_WINNER(5, false, 1_500_000),
	FOURTH_WINNER(4, false, 50_000),
	FIFTH_WINNER(3, false, 5_000),
	LOSING_TICKET(0, false, 0);

	private int matchNumberCount;
	private boolean bonusGame;
	private long reward;

	LottoWinnerType(int matchNumberCount, boolean bonusGame, long reward) {
		this.matchNumberCount = matchNumberCount;
		this.bonusGame = bonusGame;
		this.reward = reward;
	}

	public int getMatchNumberCount() {
		return matchNumberCount;
	}

	public long getReward() {
		return reward;
	}

	public boolean isMatchCount(int matchingCount) {
		return this.matchNumberCount == matchingCount;
	}

	public boolean isBonusGame() {
		return this.bonusGame;
	}

	public static LottoWinnerType findByMatchingCountAndBonus(final int matchingCount, final boolean hasBonusNumber) {
		return Arrays.stream(LottoWinnerType.values())
			.filter(lottoWinnerType -> lottoWinnerType.isMatchCount(matchingCount))
			.filter(lottoWinnerType -> lottoWinnerType.isBonusGame() ? hasBonusNumber : true)
			.findFirst().orElse(LOSING_TICKET);
	}

	public static List<LottoWinnerType> getWinnerList() {
		return Collections.unmodifiableList(Arrays.asList(FIRST_WINNER, SECOND_WINNER, THIRD_WINNER, FOURTH_WINNER, FIFTH_WINNER));
	}
}
