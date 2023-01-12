package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryMachine {

	public Lottos issue(Money money) {
		final int size = calculateLottoCount(money);

		return Lottos.of(IntStream.range(0, size)
			.mapToObj(i -> new Lotto())
			.collect(Collectors.toList()));
	}

	public Lottos issue(Money money, ListOfLottoNumbers manualLottoNumbers) {
		List<Lotto> manualLottos = manualLottoNumbers.getListOfNumbers()
			.stream()
			.map(lottoNumbers -> new Lotto(lottoNumbers.getNumbers())).collect(Collectors.toList());

		final int autoLottoSize = calculateLottoCount(money) - manualLottoNumbers.getListOfNumbers().size();

		List<Lotto> autoLottos = IntStream.range(0, autoLottoSize)
			.mapToObj(i -> new Lotto())
			.collect(Collectors.toList());

		return Lottos.of(manualLottos, autoLottos);
	}

	private int calculateLottoCount(Money money) {
		return money.getValue() / Lotto.PRICE;
	}
}
