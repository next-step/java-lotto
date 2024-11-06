package step2.domain.var;

import java.util.Arrays;

public enum LottoPrize {
	MISS(0, 0),
	FIFTH(3, 5_000),
	FOURTH(4, 50_000),
	THIRD(5, 1_500_000),
	SECOND(5, 30_000_000),
	FIRST(6, 2_000_000_000);

	private final int count;
	private final int prize;

	LottoPrize(int count, int prize) {
		this.count = count;
		this.prize = prize;
	}

	public static LottoPrize valueOf(int count, boolean matchBonus) {
		if (count < FIFTH.getCount()) {
			return MISS;
		}
		if (matchBonus && count == SECOND.getCount()) {
			return SECOND;
		}

		return Arrays
			.stream(LottoPrize.values())
			.filter((item) -> item.getCount() == count)
			.findFirst()
			.orElseThrow();
	}

	public int getCount() {
		return count;
	}

	public int getPrize() {
		return prize;
	}
}
