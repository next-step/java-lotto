package lotto.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum Prize {
	MATCHED_0(0, 0, hasBonusNumber -> true),
	MATCHED_3(3, 5000, hasBonusNumber -> true),
	MATHCED_4(4, 50000, hasBonusNumber -> true),
	MATHCED_5(5, 1500000, hasBonusNumber -> !hasBonusNumber),
	MATHCED_5_WITH_BONUS(5, 30000000, hasBonusNumber -> hasBonusNumber),
	MATHCED_6(6, 2000000000, hasBonusNumber -> true);

	private final long count;
	private final int price;
	private final Function<Boolean, Boolean> checkBonusNumber;

	Prize(long count, int price, Function<Boolean, Boolean> checkBonusNumber) {
		this.count = count;
		this.price = price;
		this.checkBonusNumber = checkBonusNumber;
	}

	public long getCount() {
		return count;
	}

	public int getPrice() {
		return price;
	}

	public static Prize from(long count, boolean hasBonusNumber) {
		return Arrays.stream(values())
				.filter(prize -> prize.count == count && prize.checkBonusNumber.apply(hasBonusNumber))
				.findFirst()
				.orElse(MATCHED_0);
	}
}
