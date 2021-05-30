package lotto;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

	public static final int LOTTO_PRICE = 1000;

	private int money;

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

	public int buyLimit() {
		return money / LOTTO_PRICE;
	}

	public Lottos buyAutoAll() {
		List<Lotto> values = new ArrayList<>();

		for (int i = 0; i < buyLimit(); i++) {
			values.add(LottoGenerator.generate());
		}

		Lottos lottos = new Lottos(values);
		payMoney(lottos.count());
		return lottos;
	}

	public Lottos buyManual(Lottos lottos) {
		payMoney(lottos.count());
		return new Lottos(lottos.values());
	}

	private void payMoney(int count) {
		validateBuyCount(count);

		money -= count * LOTTO_PRICE;
	}

	private void validateBuyCount(int count) {
		if (buyLimit() < count) {
			throw new NotEnoughMoneyException(count + "개 만큼 살 수 없습니다.");
		}
	}
}
