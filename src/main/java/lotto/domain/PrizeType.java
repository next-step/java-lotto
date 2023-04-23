package lotto.domain;

import java.util.Arrays;

public enum PrizeType {

	THREE(3, 5000),
	FOUR(4, 50000),
	FIVE(5, 1500000),
	SIX(6, 2000000000);

	public final int winCount;
	public final int prizeMoney;

	PrizeType(int winCount, int prizeMoney) {
		this.winCount = winCount;
		this.prizeMoney = prizeMoney;
	}

	public static PrizeType of(int winCount) {
		return Arrays.stream(values())
			.filter(e -> e.winCount == winCount)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상금 타입입니다."));
	}
}
