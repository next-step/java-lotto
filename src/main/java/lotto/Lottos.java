package lotto;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
	private final List<Lotto> lottos;

	private Lottos(List<Lotto> lottos) {
		this.lottos = Collections.unmodifiableList(lottos);
	}

	public static Lottos of(List<Lotto> lottos) {
		return new Lottos(lottos);
	}

	public static Lottos of(int numOfLotto) {
		return IntStream.range(0, numOfLotto)
			.mapToObj(index -> Lotto.createRandom())
			.collect(collectingAndThen(toList(), Lottos::new));
	}

	public LottoResults compareResult(Lotto targetLotto) {
		List<LottoResult> lottoResults = lottos.stream()
			.map(lotto -> lotto.compareResult(targetLotto))
			.collect(toList());
		return LottoResults.of(lottoResults);
	}

	public int size() {
		return lottos.size();
	}
}
