package nextstep.step2.domain;

import java.util.stream.Stream;

public enum LottoReward {
	FIRST(6, "2000000000원"),
	SECOND(5, "1500000원"),
	THIRD(4, "50000"),
	FOURTH(3, "5000원"),
	LAST(0, "0원");

	private final int count;
	private final String price;

	LottoReward(int count, String price) {
		this.count = count;
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public String getPrice() {
		return price;
	}

	public static LottoReward getReword(int count) {
		return Stream.of(values())
				.filter(reward -> reward.count == count)
				.findFirst()
				.orElse(LAST);
	}
}
