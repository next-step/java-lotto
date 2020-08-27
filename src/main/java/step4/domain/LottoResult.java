package step4.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoResult {
	private final List<Lotto> issueLottos;
	private final WinningLotto winningLotto;
	private final LottoStatistic statistic;

	private static final int LOTTO_PRICE = 1000;

	public LottoResult(List<Lotto> issueLottos, WinningLotto winningLotto) {
		this.issueLottos = issueLottos;
		this.winningLotto = winningLotto;
		this.statistic = new LottoStatistic();
	}

	public Map<Rank, Integer> getLottoResult() {
		return statistic.calcLottoResult(issueLottos, winningLotto);
	}

	public BigDecimal getGameYield() {
		return statistic.calcYield(issueLottos.size()*LOTTO_PRICE);
	}

}
