package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public LottoResults match(Lotto winningLotto) {
		List<Rank> ranks = new ArrayList<>();
		for (Lotto lotto : this.lottos) {
			Rank rank = lotto.findRank(winningLotto);
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
