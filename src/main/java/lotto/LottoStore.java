package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
	private static final int LOTTO_PRICE = 1_000;

	public static Lottos buy(int purchaseAmount) {
		Purchase purchase = Purchase.of(purchaseAmount);
		int numOfLotto = purchase.getBuyableCount(LOTTO_PRICE);

		return new Lottos(mapToLottos(numOfLotto));
	}

	private static List<Lotto> mapToLottos(int numOfLotto) {
		return IntStream.range(0, numOfLotto)
			.mapToObj(index -> Lotto.createRandom())
			.collect(Collectors.toList());
	}
}
