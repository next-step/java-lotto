package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoMatcher;
import lotto.domain.LottoRank;
import lotto.view.InputVIew;
import lotto.view.ResultView;
import java.util.List;
import java.util.Map;

public class Client {
	public static void main(String[] args) {
		InputVIew inputVIew = new InputVIew();
		ResultView resultView = new ResultView();

		try {
			LottoMachine lottoMachine = new LottoMachine(inputVIew.purchasingPrice());
			resultView.showBuyingCount(lottoMachine.getBuyingCount());

			List<Lotto> lottos = lottoMachine.publish();
			resultView.showPickNumbers(lottos);

			LottoMatcher lottoMatcher = new LottoMatcher(lottos, inputVIew.lastWeekNumbers());
			Map<LottoRank, Integer> ranks = lottoMatcher.matchWinning();
			resultView.showStatistics(ranks);

			LottoCalculator lottoCalculator = new LottoCalculator();
			double rateOfReturn = lottoCalculator.requestRateOfReturn(ranks, lottoMachine.getBuyingCount());
			resultView.showRateOfReturns(rateOfReturn);

			inputVIew.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
