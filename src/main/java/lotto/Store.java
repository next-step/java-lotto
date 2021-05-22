package lotto;

import java.util.ArrayList;
import java.util.List;

public class Store {
	public static final int LOTTO_PRICE = 1000;

	public static Lottos buy(int amount) {
		List<Lotto> lottos = new ArrayList<>();

		while (isBuyable(amount)) {
			Lotto lotto = Lotto.publish();
			lottos.add(lotto);
			amount -= LOTTO_PRICE;
		}
		return new Lottos(lottos);
	}

	private static boolean isBuyable(int amount) {
		return amount >= LOTTO_PRICE;
	}
}
