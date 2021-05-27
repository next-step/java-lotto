package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos() {
		this.lottos = new ArrayList<>();
	}

	public Lottos(Lotto... lottos) {
		this.lottos = Arrays.asList(lottos);
	}

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public LottoResults findResult(WinningLotto winningLotto) {
		List<Rank> ranks = new ArrayList<>();
		for (Lotto lotto : lottos) {
			Rank rank = winningLotto.findRank(lotto);
			ranks.add(rank);
		}
		return new LottoResults(ranks);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public int size() {
		return lottos.size();
	}

	public boolean isEmpty() {
		return lottos.isEmpty();
	}

	public void addLottos(Lottos lottos) {
		addAll(lottos.getLottos());
	}

	private void addAll(List<Lotto> lottos) {
		this.lottos.addAll(lottos);
	}
}
