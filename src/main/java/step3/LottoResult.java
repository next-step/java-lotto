package step3;

import step3.domain.Lotto;
import step3.domain.LottoStatistic;
import step3.domain.LottoWinning;
import step3.view.InputView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoResult {
	private final List<Lotto> issueLottos;
	private LottoStatistic statistic;

	private static final int LOTTO_PRICE = 1000;

	public LottoResult(List<Lotto> issueLottos) {
		this.issueLottos = issueLottos;
	}

	public Map<LottoWinning, Integer> getGameResult() {
		Lotto winningLotto = InputView.inputWinningNumbers();
		int bonusNumber = InputView.inputBonusBall();

		statistic = new LottoStatistic(winningLotto, bonusNumber);
		return statistic.calcLottoResult(issueLottos);
	}

	public BigDecimal getGameStatistic() {
		return statistic.calcYield(issueLottos.size()*LOTTO_PRICE);
	}

}
