package step2_3;


import step2_3.domain.Lotto;
import step2_3.domain.LottoIssuer;
import step2_3.domain.LottoStatistic;
import step2_3.view.InputView;
import step2_3.view.ResultView;

import java.util.List;

public class LottoController {
	public static void main(String[] args) {
		int price = Validator.validPrice(InputView.inputPrice());
		int lottoCount = LottoIssuer.getLottoCountByPrice(price);

		List<Lotto> lottos = LottoIssuer.issueAutoLottos(lottoCount);
		ResultView.printLottos(lottos);

		Lotto winningLotto = Validator.validWinningNumbers(InputView.inputWinningNumbers());
		int bonusNumber = Validator.validBonusBallNumber(winningLotto, InputView.inputBonusBall());

		LottoStatistic statistic = new LottoStatistic(winningLotto, bonusNumber);

		ResultView.printWinningResult(statistic.calcLottoResult(lottos));
		ResultView.printYield(statistic.calcYield(price));
	}
}
