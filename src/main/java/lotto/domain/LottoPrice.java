package lotto.domain;

public class LottoPrice {
	private static final int LOTTO_PURCHASE = 1000;
	private final int price;

	public LottoPrice(int price) {
		if(price < LOTTO_PURCHASE) {
			throw new IllegalArgumentException("1000원 이상의 금액을 입력해야 합니다.");
		}
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int getNumberOfLotto() {
		return price / LOTTO_PURCHASE;
	}
}
