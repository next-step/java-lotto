package lotto.domain;

public enum AmountEnum {
	FIRST(6) {
		@Override
		public Integer getAmount() {
			return 2000000000;
		}
	},
	SECOND(5) {
		@Override
		public Integer getAmount() {
			return 1500000;
		}
	},
	THIRD(4) {
		@Override
		public Integer getAmount() {
			return 50000;
		}
	},
	FOURTH(3) {
		@Override
		public Integer getAmount() {
			return 5000;
		}
	},
	OTHER(0) {
		@Override
		public Integer getAmount() {
			return 0;
		}
	};

	private final Integer collectedCount;

	AmountEnum(Integer collectedCount) {
		this.collectedCount = collectedCount;
	}

	public abstract Integer getAmount();

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
