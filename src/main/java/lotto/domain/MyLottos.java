package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class MyLottos {
	private final static int LOTTO_PRICE = 1000;

	private final List<Lotto> lottos;

	public MyLottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static MyLottos rollLottos(int amount) {
		List<Lotto> lottoList = Stream.generate(() -> new Lotto())
				.limit(getCount(amount))
				.collect(Collectors.toList());

		return new MyLottos(lottoList);
	}

	private static int getCount(final int amount) {
		int count = amount / LOTTO_PRICE;
		return count;
	}

	public List<Lotto> getLottos() {
		return List.copyOf(lottos);
	}

	public Integer getLottoCount() {
		return lottos.size();
	}

	public Winners findWinner(final Lotto winLotto, final LottoNumber bonusNumber) {
		return lottos.stream()
				.collect(Collectors.groupingBy(lotto -> lotto.getAmountEnumCompareWinNumber(winLotto, bonusNumber), counting()))
				.entrySet()
				.stream()
				.map(entry -> new Winner(entry.getKey(), entry.getValue()))
				.collect(Collectors.collectingAndThen(Collectors.toList(), Winners::new));
	}
}
