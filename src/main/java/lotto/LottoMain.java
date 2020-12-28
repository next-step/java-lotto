package lotto;

import lotto.modal.Count;
import lotto.modal.Lotto;
import lotto.modal.LottoNumber;
import lotto.modal.LottoResult;
import lotto.modal.Lottos;
import lotto.modal.Money;
import lotto.modal.WinnerLotto;
import lotto.view.UserView;

public class LottoMain {

	public static void main(String[] args) {
		try {
			lottoPlay();
		} catch (IllegalArgumentException exception) {
			UserView.printError(exception.getMessage());
		}
	}

	private static void lottoPlay() {
		Money money = getMoney();
		Count count = getCount(money);
		Lottos lottos = getLottos(count);
		UserView.printLottos(lottos, count);

		WinnerLotto winnerLotto = getWinnerLotto();
		LottoResult result = getLottoResult(lottos, winnerLotto);

		UserView.printResult(result, money);
	}

	private static Money getMoney() {
		return Money.generateMoney(UserView.getMoney());
	}

	private static Count getCount(Money money) {
		return Count.generateCount(UserView.getCount(), money.getBuyCount());
	}

	private static Lottos getLottos(Count count) {
		int manualCount = count.manualCount();
		Lottos lottos = Lottos.generateLottos();

		if (manualCount <= 0) {
			UserView.printInputLottos();
		}
		for (int i = 0; i < manualCount; i++) {
			lottos.addManualLottos(UserView.getLotto());
		}
		lottos.addRandomLotto(count.randomCount());

		return lottos;
	}

	private static WinnerLotto getWinnerLotto() {
		Lotto winnerLotto = Lotto.generateManualLotto(UserView.getWinnerLotto());
		LottoNumber bonusNumber = LottoNumber.generateNumber(UserView.getBonusNumber());

		return WinnerLotto.generateWinner(winnerLotto, bonusNumber);
	}

	private static LottoResult getLottoResult(Lottos lottos, WinnerLotto winnerLotto) {
		return LottoResult.generateResult(lottos, winnerLotto);
	}
}
