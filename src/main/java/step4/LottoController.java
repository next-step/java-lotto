package step4;

import step4.domain.*;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class LottoController {
	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame();

		int price = InputView.inputPrice();
		int manualLottoCount = InputView.inputManualLottoCount();
		lottoGame.checkLottoPurchase(price, manualLottoCount);

		List<Lotto> manualLottos = InputView.inputManualLottos(manualLottoCount);

		List<Lotto> issueLottos = lottoGame.getLottos(manualLottos);
		ResultView.printLottos(issueLottos);

		WinningLotto winningLotto = InputView.inputWinningNumbers();
		winningLotto.setBonusNumber(new LottoNumber(InputView.inputBonusBall()));
		LottoResult result = new LottoResult(issueLottos, winningLotto);

		ResultView.printWinningResult(result.getLottoResult());
		ResultView.printYield(result.getGameYield());
	}
}