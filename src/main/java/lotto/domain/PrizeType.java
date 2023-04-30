package lotto.domain;

import java.util.Arrays;

public enum PrizeType {

	THREE(new Score(3, 0), 5_000),
	FOUR(new Score(4, 0), 50_000),
	FIVE(new Score(5, 0), 1_500_000),
	FIVE_BONUS(new Score(5, 1), 30_000_000),
	SIX(new Score(6, 0), 2_000_000_000);

	public final Score score;
	public final PrizeMoney prizeMoney;

	PrizeType(Score score, long prizeMoney) {
		this.score = score;
		this.prizeMoney = new PrizeMoney(prizeMoney);
	}

	public static PrizeType of(Score score) {
		return Arrays.stream(values())
			.filter(e -> e.score.equals(score))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상금 타입입니다."));
	}
}
