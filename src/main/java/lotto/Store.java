package lotto;

import java.util.ArrayList;
import java.util.List;

public class Store {
	public static final long LOTTO_PRICE = 1000L;

	public static Lottos buy(Money amount) {
		List<Lotto> lottos = new ArrayList<>();
		while (isBuyable(amount)) {
			Lotto lotto = Lotto.publish();
			lottos.add(lotto);
			amount = amount.minus(LOTTO_PRICE);
		}
		return new Lottos(lottos);
	}

	private static boolean isBuyable(Money amount) {
		return amount.greaterThan(LOTTO_PRICE);
	}
}
