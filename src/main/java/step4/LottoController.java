package step4;

import step4.domain.*;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class LottoController {
	public static void main(String[] args) {
		int price = InputView.inputPrice();
		int manualLottoCount = InputView.inputManualLottoCount();
		LottoGame lottoGame = new LottoGame(price, manualLottoCount);

		List<Lotto> manualLottos = InputView.inputManualLottos(manualLottoCount);
		Lottos issueLottos = lottoGame.getAllLottos(manualLottos);
		ResultView.printLottos(issueLottos);

		List<LottoNumber> winningLotto = InputView.inputWinningNumbers();
		int bonusNumber = InputView.inputBonusBall();
		LottoStatistic statistic = new LottoStatistic();
		ResultView.printWinningResult(statistic.calcLottoResult(issueLottos, new WinningLotto(winningLotto, bonusNumber)));
		ResultView.printYield(statistic.calcYield(issueLottos.size()));
	}
}