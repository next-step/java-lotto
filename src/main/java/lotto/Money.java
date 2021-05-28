package lotto;

import java.util.ArrayList;
import java.util.List;

public class Money {

	public static final int LOTTO_PRICE = 1000;

	private final int value;

	public Money(int value) {
		validateMoneyValue(value);

		this.value = value;
	}

	private static void validateMoneyValue(int value) {
		if (value < 0) {
			throw new OutOfBoundValueException("금액은 음수가 될 수 없습니다.");
		}

		if (value < LOTTO_PRICE) {
			throw new NotEnoughMoneyException("로또를 구입하기엔 돈이 부족합니다.");
		}
	}

	public Lottos buyAll() {
		List<Lotto> values = new ArrayList<>();

		for (int i = 0; i < value / LOTTO_PRICE; i++) {
			values.add(LottoGenerator.randomNumbers());
		}

		return new Lottos(values);
	}
}
