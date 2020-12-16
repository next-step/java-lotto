package edu.nextstep.lotto.domain;

import java.math.BigDecimal;
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

	public BigDecimal getProfitRatio() {
		BigDecimal profit = BigDecimal.valueOf(getResultAsCountingMap()
			.entrySet()
			.stream()
			.mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
			.sum());
		BigDecimal usedMoney = BigDecimal.valueOf((long)soldLottos.size() * Lotto.PRICE);
		return profit.divide(usedMoney, 2, BigDecimal.ROUND_DOWN);
	}
}