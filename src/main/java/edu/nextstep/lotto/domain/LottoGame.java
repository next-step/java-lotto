package edu.nextstep.lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoGame {
	private final Lottos soldLottos;
	private final Lotto winningLotto;

	public LottoGame(List<List<Integer>> soldLottos, List<Integer> winningLotto) {
		this.soldLottos = new Lottos(soldLottos);
		this.winningLotto = new Lotto(winningLotto);
	}

	public Map<LottoRank, Long> getResultAsCountingMap() {
		return soldLottos.getResultAsCountingMap(winningLotto);
	}
}