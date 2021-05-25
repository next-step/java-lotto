package lotto.domain;

import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public LottoResults match(Lotto winningLotto) {
		LottoResults lottoResults = new LottoResults();
		for (Lotto lotto : this.lottos) {
			Rank rank = lotto.findRank(winningLotto);
			lottoResults.add(rank);
		}
		return lottoResults;
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}

	public int size() {
		return this.lottos.size();
	}

}
