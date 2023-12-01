package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
	private final int amount;
	private final LottoNumbers lottoNumbers;

	public LottoGenerator(int amount, LottoNumbers lottoNumbers) {
		this.amount = amount;
		this.lottoNumbers = lottoNumbers;
	}

	public Lottos generate() {
		List<Lotto> lottos = Stream
				.generate(() -> new Lotto(lottoNumbers.lottoNumbers()))
				.limit(amount)
				.collect(Collectors.toList());
		return new Lottos(lottos);
	}

	public List<Lotto> generateLottos() {
		return Stream
				.generate(() -> new Lotto(lottoNumbers.lottoNumbers()))
				.limit(amount)
				.collect(Collectors.toList());
	}
}
