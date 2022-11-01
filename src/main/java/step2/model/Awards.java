package step2.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Awards {
	THREE(3, 5000),
	FOUR(4, 50000),
	FIVE(5, 150000),
	SIX(6, 2000000000),
	DEFAULT(0, 0);

	private final int hitCnt;
	private final int award;
	private static final Map<Integer, Awards> awardsValueMap = new HashMap<>();

	static {
		Arrays.stream(values())
				.forEachOrdered(awards -> awardsValueMap.put(awards.hitCnt, awards));
	}

	Awards(int hitCnt, int award) {
		this.hitCnt = hitCnt;
		this.award = award;
	}

	public static Awards findAward(final int hitCnt) {
		return awardsValueMap.getOrDefault(hitCnt, DEFAULT);

	}

	public int getAward() {
		return award;
	}
}
