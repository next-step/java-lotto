package lotto;

import lotto.modal.LottoGame;
import lotto.modal.Money;
import lotto.view.UserView;

public class LottoMain {

	public static void main(String[] args) {

		try {
			Money money = UserView.getUserInputMoney();
			LottoGame lottoGame = new LottoGame(money);

			UserView.printLottoPackage(lottoGame.getLottoPackage());
			lottoGame.play(UserView.getUserInputLotto());

			UserView.printLottoResult(lottoGame.getLottoResult());
		} catch (IllegalArgumentException illegalArgumentException) {
			UserView.printErrorMsg(illegalArgumentException.getMessage());
		}
	}
}
