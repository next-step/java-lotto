package step3.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Awards {
	DEFAULT(0, 0),
	SIX(6, 2000000000),
	FIVE_BONUS(5, 30000000),
	FIVE(5, 150000),
	FOUR(4, 50000),
	THREE(3, 5000);

	private static final List<Awards> awards;

	static {
		awards = Arrays.stream(Awards.values()).collect(Collectors.toList());
	}

	private final int hitCnt;
	private final int award;

	Awards(int hitCnt, int award) {
		this.hitCnt = hitCnt;
		this.award = award;
	}

	public static int rank(final int matchCnt, final boolean matchBonus) {
		if (matchCnt == 6) return SIX.ordinal();
		if (matchCnt == 5 && matchBonus) return FIVE_BONUS.ordinal();
		if (matchCnt == 5) return FIVE.ordinal();
		if (matchCnt == 4) return FOUR.ordinal();
		if (matchCnt == 3) return THREE.ordinal();

		return DEFAULT.ordinal();
	}

	public static boolean isBonus(int i){
		return FIVE_BONUS.ordinal() == i;
	}

	public static int getPrize(int awardRank, int awardCnt) {
		return awards.get(awardRank).award * awardCnt;
	}

	public static int getHitCnt(int rank) {
		return awards.get(rank).hitCnt;
	}

	public static int getAward(int rank) {
		return awards.get(rank).award;
	}
}
