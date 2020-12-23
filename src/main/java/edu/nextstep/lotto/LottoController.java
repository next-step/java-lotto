package edu.nextstep.lotto;

import java.util.List;

import edu.nextstep.lotto.domain.LottoGame;
import edu.nextstep.lotto.domain.Money;
import edu.nextstep.lotto.domain.sub.LottoGameResult;
import edu.nextstep.lotto.domain.sub.LottoNumbers;
import edu.nextstep.lotto.util.NumberUtil;
import edu.nextstep.lotto.view.InputView;
import edu.nextstep.lotto.view.ResultView;

public class LottoController {

	public static boolean isValidLottoNumbers(List<Integer> numbers) {
		return LottoNumbers.isValid(numbers);
	}

	public void play() {
		Money money = new Money(InputView.inputMoney());
		int numberOfManual = InputView.inputManualPurchaseNumber();
		money.purchaseLotto(numberOfManual);
		List<List<Integer>> manualNumbersList = InputView.inputManualNumbersList(numberOfManual);

		int numberOfPurchase = money.howManyPurchase();

		ResultView.printHowManyPurchase(numberOfPurchase);

		List<List<Integer>> purchasedLottoNumbersList = NumberUtil.getRandomLottoNumbersList(numberOfPurchase);
		ResultView.printLottos(purchasedLottoNumbersList);

		List<Integer> winningNumbers = InputView.inputWinningNumbers();
		int bonusNumber = InputView.inputBonusNumber();
		LottoGame lottoGame = new LottoGame(purchasedLottoNumbersList, winningNumbers, bonusNumber);
		LottoGameResult lottoGameResult = lottoGame.getResult();

		ResultView.printWinningStatistics(lottoGameResult.getResultMap());
		ResultView.printProfitRatio(lottoGameResult.getProfitRatio());
	}

	public void playUntilNoError() {
		try {
			play();
		} catch (IllegalArgumentException ex) {
			ResultView.printError(ex.getMessage());
			playUntilNoError();
		}
	}
}