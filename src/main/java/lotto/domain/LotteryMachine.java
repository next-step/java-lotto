package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryMachine {

	public Lottos issue(Money money) {
		int size = calculateLottoSize(money);

		return Lottos.of(IntStream.range(0, size)
			.mapToObj(i -> new Lotto())
			.collect(Collectors.toList()));
	}

	private int calculateLottoSize(Money money) {
		return money.getValue() / Lotto.PRICE;
	}
}
