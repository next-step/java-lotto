package lotto.model;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.utils.LottoCountCalculator;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;

	public static Lottos buyLottos(Money money) {
		return new Lottos(
			IntStream.range(START_INCLUSIVE, LottoCountCalculator.calculateLottoCount(money.getPurchaseMoney()))
				.mapToObj(i -> LottoMachine.createLottoNumbers())
				.collect(Collectors.toList()));
	}

	public static Lottos buyLottos(Money money, StringBuilder inputManualLottos) {

		return null;
	}
}
