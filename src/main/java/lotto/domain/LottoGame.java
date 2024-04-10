package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private Money money;

	public LottoGame(int money) {
		this.money = new Money(money);
	}

	public List<Lotto> createLotto(NumberStrategy numberStrategy) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < money.countOfBuyLotto(); i++) {
			lottos.add(Lotto.of(numberStrategy.generateNumber()));
		}
		return lottos;
	}

	public int countOfLottos() {
		return money.countOfBuyLotto();
	}
}
