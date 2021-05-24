package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private static final int LOTTO_PRICE = 1000;

	private final List<Lotto> lottos;

	public Lottos(int money) {
		validateMoney(money);

		lottos = new ArrayList<>();

		int lottoCount = money / LOTTO_PRICE;
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(new Lotto(LottoUtils.randomNumbers()));
		}
	}

	public int count() {
		return lottos.size();
	}

	private void validateMoney(int money) {
		if (money < LOTTO_PRICE) {
			throw new IllegalArgumentException("Not enough money to buy a lotto.");
		}
	}
}
