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

	public int numberOfBoughtLottos() {
		return lottos.size();
	}

	public LottoResult getWinningResult(WinningNumber winningNumber) {
		return LottoResult.of(lottos.stream()
				.map(lotto -> lotto.checkWinning(winningNumber))
				.collect(Collectors.toList()));
	}

	@Override
	public String toString() {
		return lottos.stream()
				.map(Lotto::toString)
				.collect(Collectors.joining(Constants.JOINING_DELIMITER));
	}
}
