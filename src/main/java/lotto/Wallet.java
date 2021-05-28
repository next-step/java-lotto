package lotto;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

	public static final int LOTTO_PRICE = 1000;

	private final int money;

	public Wallet(int money) {
		validateMoneyValue(money);

		this.money = money;
	}

	private static void validateMoneyValue(int money) {
		if (money < 0) {
			throw new OutOfBoundValueException("금액은 음수가 될 수 없습니다.");
		}

		if (money < LOTTO_PRICE) {
			throw new NotEnoughMoneyException("로또를 구입하기엔 돈이 부족합니다.");
		}
	}

	public Lottos buyAll() {
		List<Lotto> values = new ArrayList<>();

		for (int i = 0; i < money / LOTTO_PRICE; i++) {
			values.add(LottoGenerator.randomNumbers());
		}

		return new Lottos(values);
	}
}
