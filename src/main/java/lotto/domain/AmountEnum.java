package lotto.domain;

import java.util.Arrays;

public enum AmountEnum {
	FIRST(6, 2000000000, false),
	SECOND(5, 30000000, true),
	THIRD(5, 1500000, false),
	FOURTH(4, 50000, false),
	FIFTH(3, 5000, false),
	OTHER(0, 0, false);

	private final Integer collectedCount;
	private final Integer amount;
	private final Boolean isBonus;

	AmountEnum(Integer collectedCount, Integer amount, Boolean isBonus) {
		this.collectedCount = collectedCount;
		this.amount = amount;
		this.isBonus = isBonus;
	}

	public Integer getAmount() {
		return amount;
	}

	public static AmountEnum from(final Integer collectedCount, final Boolean isBonus) {
		if (isSecond(collectedCount, isBonus)) {
			return AmountEnum.SECOND;
		}

		return Arrays.stream(AmountEnum.values())
				.filter(amountEnum -> amountEnum.collectedCount.equals(collectedCount) && amountEnum.isBonus.equals(false))
				.findFirst().orElse(OTHER);
	}

	private static boolean isSecond(Integer collectedCount, Boolean isBonus) {
		return isBonus.equals(true) && collectedCount.equals(5);
	}
}
