package lotto;

import static type.LottoExceptionType.WRONG_LOTTO_PRICE;

public class LottoMoney {

	private static final int LOTTO_PRICE = 1000;

	private final int price;

	public LottoMoney(final int price) {
		if (price <= 0) {
			throw new IllegalArgumentException(WRONG_LOTTO_PRICE.message());
		}
		this.price = price;
	}

	public int calculateLottoCount() {
		return Integer.divideUnsigned(price, LOTTO_PRICE);
	}

	public int price(){
		return this.price;
	}
}
