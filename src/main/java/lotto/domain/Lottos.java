package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos() {
		this.lottos = new ArrayList<>();
	}

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public LottoResults match(Lotto winningLotto) {
		LottoResults lottoResults = new LottoResults();
		for (Lotto lotto : this.lottos) {
			Rank rank = lotto.findRank(winningLotto);
			lottoResults.add(new LottoResult(rank));
		}
		return lottoResults;
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}

	public void add(Lotto lotto) {
		this.lottos.add(lotto);
	}

	public int size() {
		return this.lottos.size();
	}

}
