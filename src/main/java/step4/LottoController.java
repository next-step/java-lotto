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

		LottoGame lottoGame = new LottoGame(price, manualLottoCount);

		String[] manualLottos = InputView.inputManualLottos(manualLottoCount);
		Lottos issueLottos = lottoGame.buyLotto(manualLottos);
		ResultView.printLottos(manualLottoCount, issueLottos);

		List<LottoNumber> winningLotto = InputView.inputWinningNumbers()
				.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toList());
		int bonusNumber = InputView.inputBonusBall();

		LottoStatistic statistic = new LottoStatistic();
		ResultView.printWinningResult(
				statistic.calculateLottoResult(
						issueLottos,
						new WinningLotto(new Lotto(winningLotto), bonusNumber)));
		ResultView.printYield(statistic.calculateYield(issueLottos.size()));
	}
}
