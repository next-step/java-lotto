package im.juniq.lotto;

public enum Winning {
	SIX_NUMBERS_MATCHED(2000000000L),
	FIVE_NUMBERS_MATCHED(15000000L),
	FOUR_NUMBERS_MATCHED(50000L),
	THREE_NUMBERS_MATCHED(5000L);

	private Long amount;

	Winning(Long amount) {
		this.amount = amount;
	}

	public Long amount() {
		return amount;
	}
}
