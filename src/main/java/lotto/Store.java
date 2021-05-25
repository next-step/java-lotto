package lotto;

import java.util.ArrayList;
import java.util.List;

public class Store {
	public static final Money LOTTO_PRICE = new Money(1_000L);

	public static Lottos buy(Money amount) {
		List<Lotto> lottos = new ArrayList<>();

		int count = (int)amount.divide(LOTTO_PRICE);
		for (int i = 0; i < count; i++) {
			Lotto lotto = Lotto.publish();
			lottos.add(lotto);
		}
		return new Lottos(lottos);
	}
}
