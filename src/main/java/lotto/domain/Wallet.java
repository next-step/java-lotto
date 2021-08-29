package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wallet {
	private final static int PRICE_OF_LOTTO = 1000;
	private int money;

	public Wallet(int money) {
		this.money = money;
	}

	public int numberOfThingsToBuy() {
		return money / PRICE_OF_LOTTO;
	}

	public Lottos buyLotto(int count) {
		List<Lotto> lottos = new ArrayList<>();
		LottoCard lottoCard = LottoCard.getInstance();
		for (int i = 0; i < count; i++) {
			Lotto lotto = lottoCard.issue();
			lottos.add(lotto);
		}
		deduction(count);
		return new Lottos(lottos);
	}

	private void deduction(int count) {
		money -= count * PRICE_OF_LOTTO;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Wallet wallet = (Wallet)o;
		return money == wallet.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
