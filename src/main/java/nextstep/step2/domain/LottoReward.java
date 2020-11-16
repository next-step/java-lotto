package nextstep.step2.domain;

import java.util.stream.Stream;

public enum LottoReward {
	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000),
	LOST(0, 0);

	private final int count;
	private final int price;

	LottoReward(int count, int price) {
		this.count = count;
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public int getPrice() {
		return price;
	}

	public static LottoReward getReword(int count) {
		return Stream.of(values())
				.filter(reward -> reward.count == count)
				.findFirst()
				.orElse(LOST);
	}
}
