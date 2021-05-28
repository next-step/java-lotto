package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
	FIRST(2000000000, 6),
	SECOND(30000000, 5, true),
	THIRD(1500000, 5),
	FOURTH(50000, 4),
	FIFTH(5000, 3),
	UNRANKED(0, 0);

	private long reward;
	private int matches;
	private boolean hasBonusBall;

	LottoRank(final long reward, final int matches) {
		this.reward = reward;
		this.matches = matches;
		this.hasBonusBall = false;
	}

	LottoRank(final long reward, final int matches, final boolean hasBonusBall) {
		this(reward, matches);
		this.hasBonusBall = hasBonusBall;
	}

	public static LottoRank valueOf(long matches, boolean hasBonusBall) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.matches == matches && lottoRank.hasBonusBall == hasBonusBall)
			.findFirst()
			.orElse(valueOfHasBonusBall(matches, hasBonusBall));
	}

	private static LottoRank valueOfHasBonusBall(long matches, boolean hasBonusBall) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.matches == matches && lottoRank.hasBonusBall == !hasBonusBall)
			.findFirst()
			.orElse(UNRANKED);
	}

	public long getReward() {
		return this.reward;
	}

	public int getMatches() {
		return this.matches;
	}

	public boolean hasBonusBall() {
		return this.hasBonusBall;
	}

}
