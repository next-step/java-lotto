package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public LottoResults findResult(WinningLotto winningLotto) {
		List<Rank> ranks = new ArrayList<>();
		for (Lotto lotto : this.lottos) {
			Rank rank = winningLotto.findRank(lotto);
			ranks.add(rank);
		}
		return new LottoResults(ranks);
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}

	public int size() {
		return this.lottos.size();
	}

}
