package lotto.model;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;

	public static Lottos buyLottos(Money money) {
		return new Lottos(IntStream.range(START_INCLUSIVE, money.countLotto())
			.mapToObj(i -> LottoMachine.createLottoNumbers())
			.collect(Collectors.toList()));
	}

}
