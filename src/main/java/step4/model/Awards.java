package step4.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Awards {
	DEFAULT(0, 0, 0),
	SIX(6, 2000000000, 1),
	FIVE_BONUS(5, 30000000, 2),
	FIVE(5, 150000, 3),
	FOUR(4, 50000, 4),
	THREE(3, 5000, 5);

	private static final List<Awards> awards;

	static {
		awards = Arrays.stream(Awards.values()).collect(Collectors.toList());
	}

	private final int hitCnt;
	private final int award;
	private final int rank;

	Awards(final int hitCnt, final int award, final int rank) {
		this.hitCnt = hitCnt;
		this.award = award;
		this.rank = rank;
	}

	public static int rankOf(final int matchCnt, final boolean matchBonus) {
		if (matchCnt == 5 && matchBonus) return FIVE_BONUS.rank;
		if (matchCnt == 5) return FIVE.rank;

		Awards awards = Arrays.stream(Awards.values())
				.filter(award -> award.hitCnt == matchCnt)
				.findFirst()
				.orElse(DEFAULT);

		return awards.rank;
	}

	public static boolean isBonus(final int i) {
		return FIVE_BONUS.rank == i;
	}

	public static int getPrize(final int awardRank, final int awardCnt) {
		return awards.get(awardRank).award * awardCnt;
	}

	public static int getHitCnt(final int rank) {
		return awards.get(rank).hitCnt;
	}

	public static int getAward(final int rank) {
		return awards.get(rank).award;
	}
}
