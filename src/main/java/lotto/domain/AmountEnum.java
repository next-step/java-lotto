package lotto.domain;

public enum AmountEnum {
	FIRST(6, 2000000000),
	SECOND(5, 1500000),
	THIRD(4, 50000),
	FOURTH(3, 5000),
	OTHER(0, 0);

	private final Integer collectedCount;
	private final Integer amount;

	AmountEnum(Integer collectedCount, Integer amount) {
		this.collectedCount = collectedCount;
		this.amount = amount;
	}

	public Integer getAmount() {
		return amount;
	}

	public Integer getCollectedCount() {
		return collectedCount;
	}

	public static AmountEnum from(final Integer collectedCount) {
		for (AmountEnum amountEnum : AmountEnum.values()) {
			if (amountEnum.collectedCount.equals(collectedCount)) {
				return amountEnum;
			}
		}
		return OTHER;
	}
}
