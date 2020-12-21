package lotto.option;

public class LottoMoney {

	public static final int LOTTO_PRICE = 1000;
	private final long money;

	public LottoMoney(long money) {
		validate(money);
		this.money = money;
	}

	private static void validate(long money) throws IllegalArgumentException {
		if (money <= 0) {
			throw new IllegalArgumentException("money only must be positive");
		}

		if (money % LOTTO_PRICE > 0) {
			throw new IllegalArgumentException("money must not have charge");
		}
	}

	public long getLottoBuyCount() {
		return this.money / LOTTO_PRICE;
	}
}
