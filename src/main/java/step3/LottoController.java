package step3;

import step3.domain.Lotto;
import step3.view.ResultView;

import java.util.List;

public class LottoController {
	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame();
		List<Lotto> issueLottos = lottoGame.startLottoGame();
		ResultView.printLottos(issueLottos);

		LottoResult gameResult = new LottoResult(issueLottos);
		ResultView.printWinningResult(gameResult.getGameResult());
		ResultView.printYield(gameResult.getGameStatistic());
	}
}