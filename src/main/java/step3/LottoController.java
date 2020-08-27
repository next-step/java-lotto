package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class LottoController {
	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame();

		int price = InputView.inputPrice();
		List<Lotto> issueLottos = lottoGame.getLottos(price);
		ResultView.printLottos(issueLottos);

		List<LottoNumber> winningLotto = InputView.inputWinningNumbers();
		int bonusNumber = InputView.inputBonusBall();
		LottoResult result = new LottoResult(issueLottos, new WinningLotto(winningLotto, bonusNumber));

		ResultView.printWinningResult(result.getLottoResult());
		ResultView.printYield(result.getGameYield());
	}
}