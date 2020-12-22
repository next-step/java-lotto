package lotto;

import lotto.modal.Game;
import lotto.modal.GameCondition;
import lotto.modal.LottoResult;
import lotto.modal.ManualLotto;
import lotto.view.UserView;

public class LottoMain {

	private static GameCondition condition;

	public static void main(String[] args) {

		try {
			condition = createCondition();
			ManualLotto manualLotto = getManualLotto();
			Game lottoGame = createGame(manualLotto);

			lottoGameStart(lottoGame);
		} catch (IllegalArgumentException illegalArgumentException) {
			UserView.printErrorMsg(illegalArgumentException.getMessage());
		}
	}

	private static void lottoGameStart(Game lottoGame) {
		UserView.printLottoPackage(condition, lottoGame.getLottoPackage());

		LottoResult result = lottoGame.getLottoResult(UserView.inputWinnerLotto());
		UserView.printLottoResultRank(result.rankCount());
		UserView.printLottoResultYield(result.report(condition));
	}

	private static Game createGame(ManualLotto manualLotto) {
		return new Game(manualLotto, condition.getRandomCount());
	}

	private static ManualLotto getManualLotto() {
		return new ManualLotto(UserView.inputManualLotto(condition.getCount()));
	}

	private static GameCondition createCondition() {
		return new GameCondition(UserView.inputGameMoney(), UserView.inputManualCount());
	}
}
