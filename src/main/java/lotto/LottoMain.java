package lotto;

import lotto.modal.LottoGame;
import lotto.modal.LottoResult;
import lotto.modal.Money;
import lotto.view.UserView;

public class LottoMain {

	public static void main(String[] args) {

		try {
			Money money = UserView.getUserInputMoney();
			LottoGame lottoGame = new LottoGame(money);
			UserView.printLottoPackage(lottoGame.getLottoPackage());

			LottoResult result = lottoGame.getLottoResult(UserView.getUserInputLotto());

			UserView.printLottoResultRank(result.getLottoRankCounters());
			UserView.printLottoResultYield(result.report(money));
		} catch (IllegalArgumentException illegalArgumentException) {
			UserView.printErrorMsg(illegalArgumentException.getMessage());
		}
	}
}
