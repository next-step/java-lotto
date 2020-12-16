package lotto;

import lotto.modal.LottoGame;
import lotto.view.UserView;

public class LottoMain {

	public static void main(String[] args) {

		try {

			LottoGame lottoGame = new LottoGame(UserView.getUserInputMoney());

			UserView.printLottoPackage(lottoGame.getLottoPackage());
			lottoGame.start(UserView.getUserInputLotto());
			
		} catch (IllegalArgumentException illegalArgumentException) {

			UserView.printErrorMsg(illegalArgumentException.getMessage());
		}
	}
}
