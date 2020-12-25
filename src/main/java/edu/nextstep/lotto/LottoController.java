package edu.nextstep.lotto;

import java.util.List;

import edu.nextstep.lotto.domain.LottoGame;
import edu.nextstep.lotto.domain.LottosFactory;
import edu.nextstep.lotto.domain.Money;
import edu.nextstep.lotto.domain.sub.LottoGameResult;
import edu.nextstep.lotto.domain.sub.LottoNumbers;
import edu.nextstep.lotto.domain.sub.Lottos;
import edu.nextstep.lotto.view.InputView;
import edu.nextstep.lotto.view.ResultView;

public class LottoController {

	public static boolean isNotValidLottoNumbers(List<Integer> numbers) {
		return LottoNumbers.isNotValid(numbers);
	}

	public void playUntilNoError() {
		try {
			play();
		} catch (IllegalArgumentException ex) {
			ResultView.printError(ex.getMessage());
			playUntilNoError();
		}
	}

	public void play() {
		Money money = new Money(InputView.inputMoney());
		Lottos lottos = getLottoNumbersList(money);

		LottoGame lottoGame = new LottoGame(
			lottos,
			InputView.inputWinningNumbers(),
			InputView.inputBonusNumber());

		LottoGameResult lottoGameResult = lottoGame.getResult();
		ResultView.printWinningStatistics(lottoGameResult.getResultMap());
		ResultView.printProfitRatio(lottoGameResult.getProfitRatio());
	}

	private Lottos getLottoNumbersList(Money money) {
		int numberOfManual = InputView.inputManualPurchaseNumber();
		money.minusByNumberOfLotto(numberOfManual);

		List<List<Integer>> manualNumbersList = InputView.inputManualNumbersList(numberOfManual);

		Lottos purchasedLottos = LottosFactory.createPurchasedLottos(money, manualNumbersList);

		ResultView.printHowManyPurchase(purchasedLottos.size(), manualNumbersList.size());
		ResultView.printLottos(purchasedLottos.toList());

		return purchasedLottos;
	}
}