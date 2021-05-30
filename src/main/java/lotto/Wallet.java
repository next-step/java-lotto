package lotto;

import static lotto.LottoShop.*;

public class Wallet {

	private final int money;

	public Wallet(int money) {
		validateMoneyValue(money);

		this.money = money;
	}

	private static void validateMoneyValue(int money) {
		if (money < 0) {
			throw new OutOfBoundValueException("금액은 음수가 될 수 없습니다.");
		}
	}

	public Wallet pay(int price) {
		validatePrice(price);
		return new Wallet(money - price);
	}

	private void validatePrice(int price) {
		if (money < price) {
			throw new NotEnoughMoneyException("보유한 금액을 초과하여 지불할 수 없습니다.");
		}
	}

	public boolean isEnough() {
		return money >= LOTTO_PRICE;
	}

	public int buyLimit() {
		return money / LOTTO_PRICE;
	}
}
