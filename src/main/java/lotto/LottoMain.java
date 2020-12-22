package lotto;

import lotto.modal.GameManual;
import lotto.view.UserView;

public class LottoMain {

	public static void main(String[] args) {

		try {
			GameManual gameManual = new GameManual(UserView.inputGameMoney(), UserView.inputManualCount());

			//ManualLotto lotto = ;
			//Game lottoGame = new Game(money);
			//UserView.printLottoPackage(lottoGame.getLottoPackage());

			//LottoResult result = lottoGame.getLottoResult(UserView.inputWinnerLotto());

			//UserView.printLottoResultRank(result.rankCount());
			//UserView.printLottoResultYield(result.report(money));
		} catch (IllegalArgumentException illegalArgumentException) {
			UserView.printErrorMsg(illegalArgumentException.getMessage());
		}
	}
}
