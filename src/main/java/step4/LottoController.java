package step4;

import step4.domain.*;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
	public static void main(String[] args) {
		int price = InputView.inputPrice();
		int manualLottoCount = InputView.inputManualLottoCount();
		String[] manualLottos = InputView.inputManualLottos(manualLottoCount);
		LottoGame lottoGame = new LottoGame(price, manualLottos);

		Lottos issueLottos = lottoGame.getAllLottos();
		ResultView.printLottos(manualLottoCount, issueLottos);

		List<LottoNumber> winningLotto = InputView.inputWinningNumbers()
				.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toList());
		int bonusNumber = InputView.inputBonusBall();
		LottoStatistic statistic = new LottoStatistic();
		ResultView.printWinningResult(statistic.calcLottoResult(issueLottos, new WinningLotto(winningLotto, bonusNumber)));
		ResultView.printYield(statistic.calcYield(issueLottos.size()));
	}
}
