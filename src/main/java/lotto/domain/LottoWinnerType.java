package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hspark on 06/11/2018.
 */
public enum LottoWinnerType {
	FIRST_WINNER(6, 2_000_000_000),
	SECOND_WINNER(5, 1_500_000),
	THIRD_WINNER(4, 50_000),
	FOURTH_WINNER(3, 5_000),
	LOSING_TICKET(0, 0);

	private int matchNumberCount;
	private long reward;

	LottoWinnerType(int matchNumberCount, long reward) {
		this.matchNumberCount = matchNumberCount;
		this.reward = reward;
	}

	public int getMatchNumberCount() {
		return matchNumberCount;
	}

	public long getReward() {
		return reward;
	}

	public static LottoWinnerType findByMatchingCount(final int matchingCount) {
		return Arrays.stream(LottoWinnerType.values())
			.filter(lottoWinnerType -> lottoWinnerType.matchNumberCount == matchingCount)
			.findFirst().orElse(LOSING_TICKET);
	}

	public static List<LottoWinnerType> getWinnerList() {
		return Collections.unmodifiableList(Arrays.asList(FIRST_WINNER, SECOND_WINNER, THIRD_WINNER, FOURTH_WINNER));
	}
}
