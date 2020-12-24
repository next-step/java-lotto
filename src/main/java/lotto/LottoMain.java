package lotto;

import lotto.modal.Count;
import lotto.modal.Game;
import lotto.modal.LottoResult;
import lotto.modal.Lottos;
import lotto.modal.Money;
import lotto.view.UserView;

public class LottoMain {

	public static void main(String[] args) {
		try {
			Money money = getMoney();
			Count count = getCount(money);
			Lottos lottos = getLottos(count);

			Game lottoGame = createGame(lottos);

			lottoGameStart(lottoGame);
		} catch (IllegalArgumentException illegalArgumentException) {
			UserView.printErrorMsg(illegalArgumentException.getMessage());
		}
	}

	private static Money getMoney() {
		return new Money(UserView.getMoney());
	}

	private static Count getCount(Money money) {
		return new Count(UserView.getCount(), money.getBuyCount());
	}

	private static Lottos getLottos(Count count) {
		int manualCount = count.getManualBuyCount();
		Lottos lottos = new Lottos(count.getRandomCount());

		if (manualCount != 0) {
			UserView.printInputLottos();
		}
		for (int i = 0; i < manualCount; i++) {
			lottos.addLotto(UserView.getLotto());
		}

		return lottos;
	}

	private static void lottoGameStart(Game lottoGame) {
		UserView.printLottoPackage(condition, lottoGame.getLottoPackage());

		LottoResult result = lottoGame.getLottoResult(UserView.inputWinnerLotto());
		UserView.printLottoResultRank(result.rankCount());
		UserView.printLottoResultYield(result.report(condition));
	}

	private static Game createGame(Lottos manualLotto) {
		return new Game(manualLotto, condition.getRandomCount());
	}

	private static Lottos getManualLotto() {
		return new Lottos(UserView.inputManualLotto(condition.getCount()));
	}
}
