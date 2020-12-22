package lotto.option;

public class LottoMoney {

	public static final int LOTTO_PRICE = 1000;
	private static final String VALIDATE_FAIL_NEGATIVE = "money only must be positive";
	private static final String VALIDATE_FAIL_CHARGE =
			String.format("money must not have charge(unit=%d)", LOTTO_PRICE);
	private final long money;

	public LottoMoney(long money) {
		validate(money);
		this.money = money;
	}

	private static void validate(long money) throws IllegalArgumentException {
		if (money <= 0) {
			throw new IllegalArgumentException(VALIDATE_FAIL_NEGATIVE);
		}

		if (money % LOTTO_PRICE > 0) {
			throw new IllegalArgumentException(VALIDATE_FAIL_CHARGE);
		}
	}

	long getLottoBuyCount() {
		return this.money / LOTTO_PRICE;
	}
}
