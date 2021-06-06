package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Store {
	public static final Money LOTTO_PRICE = new Money(1_000L);

	public static Lottos buy(Money amount, List<List<Integer>> manualNumbers) {
		int manualCount = manualNumbers.size();
		canBuyLottos(amount, manualCount);

		List<Lotto> lottos = manualNumbers.stream().map(Lotto::new).collect(Collectors.toList());

		amount = amount.minus(Store.LOTTO_PRICE.multiply(manualCount));
		int autoCount = (int)amount.divide(LOTTO_PRICE);
		IntStream.range(0, autoCount).mapToObj(i -> Lotto.publish()).forEach(lottos::add);

		return new Lottos(lottos);
	}

	private static void canBuyLottos(Money amount, int count) {
		int maxCount = (int)amount.divide(LOTTO_PRICE);
		if (maxCount < count) {
			throw new IllegalArgumentException("수동으로 살 수 있는 금액을 넘었습니다.");
		}
	}

}
