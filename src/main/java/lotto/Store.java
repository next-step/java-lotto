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

	public static Lottos buy(Money amount, List<List<Integer>> manualNumbers) {
		canBuyLottos(amount, manualNumbers.size());

		List<Lotto> lottos = new ArrayList<>();
		for (List<Integer> manualNumber : manualNumbers) {
			lottos.add(new Lotto(manualNumber));
		}
		return new Lottos(lottos);
	}

	private static void canBuyLottos(Money amount, int count) {
		int maxCount = (int)amount.divide(LOTTO_PRICE);
		if (maxCount < count) {
			throw new IllegalArgumentException("수동으로 살 수 있는 금액을 넘었습니다.");
		}
	}

}
