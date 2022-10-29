package step2.model;

import java.util.Arrays;

public enum Awards {
	THREE(3, 5000),
	FOUR(4, 50000),
	FIVE(5, 150000),
	SIX(6, 2000000000),
	DEFAULT(0, 0);

	private final int hitCnt;
	private final int award;

	Awards(int hitCnt, int award) {
		this.hitCnt = hitCnt;
		this.award = award;
	}

	public static Awards findAward(int hitCnt) {
		return Arrays.stream(Awards.values())
				.filter(hit -> hitCnt == hit.hitCnt)
				.findFirst()
				.orElse(DEFAULT);
	}

	public int getAward() {
		return award;
	}
}
