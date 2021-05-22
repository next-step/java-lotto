package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
	FIRST(2000000000, 6),
	SECOND(1500000, 5),
	THIRD(50000, 4),
	FOURTH(5000, 3),
	UNRANKED(0, 0);

	private int reward;
	private int matches;

	LottoRank(final int reward, final int matches) {
		this.reward = reward;
		this.matches = matches;
	}

	public static LottoRank valueOf(long matches) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.matches == matches)
			.findFirst()
			.orElse(LottoRank.UNRANKED);
	}

	public int getReward() {
		return this.reward;
	}

	public int getMatches() {
		return this.matches;
	}
}
