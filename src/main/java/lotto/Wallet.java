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

	public Wallet spend(int purchasedCount) {
		int moneyLeft = money - LOTTO_PRICE * purchasedCount;

		validateMoneyLeft(moneyLeft);

		return new Wallet(moneyLeft);
	}

	private void validateMoneyLeft(int moneyLeft) {
		if (moneyLeft < 0) {
			throw new NotEnoughMoneyException("로또 갯수가 지갑 사정을 넘어섭니다.");
		}
	}

	public boolean isEnough() {
		return money >= LOTTO_PRICE;
	}

	public int buyLimit() {
		return money / LOTTO_PRICE;
	}
}
