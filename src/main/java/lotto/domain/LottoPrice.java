package lotto.domain;

public class LottoPrice {
	private static final int LOTTO_PURCHASE = 1000;
	private final int price;
	private final int numberOfAutoLotto;
	private final int numberOfManualLotto;

	public LottoPrice(int price) {
		if(price < LOTTO_PURCHASE) {
			throw new IllegalArgumentException("1000원 이상의 금액을 입력해야 합니다.");
		}
		this.price = price;
		this.numberOfAutoLotto = price / LOTTO_PURCHASE;
		this.numberOfManualLotto = 0;
	}

	public LottoPrice(int price, int numberOfInputLotto) {
		if(price < LOTTO_PURCHASE) {
			throw new IllegalArgumentException("1000원 이상의 금액을 입력해야 합니다.");
		}

		int maxNumberOfLotto = price / LOTTO_PURCHASE;

		if(maxNumberOfLotto < numberOfInputLotto) {
			throw new IllegalArgumentException("수동 로또는 " + maxNumberOfLotto + "장 까지만 구매할 수 있습니다.");
		}

		this.price = price;
		this.numberOfAutoLotto = price / LOTTO_PURCHASE - numberOfInputLotto;
		this.numberOfManualLotto = numberOfInputLotto;
	}

	public int getPrice() {
		return price;
	}

	public int getNumberOfAutoLotto() {
		return numberOfAutoLotto;
	}

	public int getNumberOfManualLotto() {
		return numberOfManualLotto;
	}
}
