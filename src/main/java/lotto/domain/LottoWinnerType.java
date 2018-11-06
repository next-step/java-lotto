package lotto.domain;

import java.util.Arrays;

/**
 * Created by hspark on 06/11/2018.
 */
public enum LottoWinnerType {
	FIRST_WINNER(6, 5_000),
	SECOND_WINNER(5, 50_000),
	THIRD_WINNER(4, 1_500_000),
	FOURTH_WINNER(3, 2_000_000_000),
	LOSING_TICKET(0, 0);

	private int matchNumberCount;
	private int reward;

	LottoWinnerType(int matchNumberCount, int reward) {
		this.matchNumberCount = matchNumberCount;
	}

	public static LottoWinnerType findByMatchingCount(final int matchingCount) {
		return Arrays.stream(LottoWinnerType.values())
			.filter(lottoWinnerType -> lottoWinnerType.matchNumberCount == matchingCount)
			.findFirst().orElse(LOSING_TICKET);
	}
}
