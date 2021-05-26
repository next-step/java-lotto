package lotto;

import java.util.List;
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

	public List<LottoPrize> comparePrize(Lotto winningLotto) {
		return lottos.stream().map(lotto -> lotto.compare(winningLotto)).collect(Collectors.toList());
	}
}
