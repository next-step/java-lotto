package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(Money money) {
		validateMoney(money);

		lottos = new ArrayList<>();
		for (int i = 0; i < money.buyCount(); i++) {
			lottos.add(new Lotto(LottoUtils.randomNumbers()));
		}
	}

	public int count() {
		return lottos.size();
	}

	private void validateMoney(Money money) {
		if (!money.isEnough()) {
			throw new IllegalArgumentException("Not enough money to buy a lotto.");
		}
	}
}
