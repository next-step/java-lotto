package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

	private List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public int lottoCount() {
		return this.lottos.size();
	}

	public List<LottoPrize> comparePrize(WinningLotto winningLotto) {
		return lottos.stream().map(lotto -> lotto.compare(winningLotto)).filter(Objects::nonNull).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
	}
}
