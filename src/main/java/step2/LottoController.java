package step2;

import step2.domain.Lotto;
import step2.domain.LottoIssuer;
import step2.domain.LottoStatistic;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoController {
	public static void main(String[] args) {
		int price = Validator.validPrice(InputView.inputPrice());
		int lottoCount = LottoIssuer.getLottoCountByPrice(price);

		List<Lotto> lottos = LottoIssuer.issueAutoLottos(lottoCount);
		ResultView.printLottos(lottos);

		Lotto winningLotto = Validator.validWinningNumbers(InputView.inputWinningNumbers());
		LottoStatistic statistic = new LottoStatistic(winningLotto);
		ResultView.printWinningResult(statistic.calcLottoResult(lottos));
		ResultView.printYield(statistic.calcYield(price));
	}
}
