package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> lottos() {
		return lottos;
	}

	public LottoResult getWinningResult(List<Integer> winningNumber) {
		return LottoResult.of(lottos.stream()
				.map(it -> it.checkWinning(winningNumber))
				.collect(Collectors.toList()));
	}
}
