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
		List<List<Integer>> lottoNumbersList = getLottoNumbersList(money);

		LottoGame lottoGame = new LottoGame(
			lottoNumbersList,
			InputView.inputWinningNumbers(),
			InputView.inputBonusNumber());

		LottoGameResult lottoGameResult = lottoGame.getResult();
		ResultView.printWinningStatistics(lottoGameResult.getResultMap());
		ResultView.printProfitRatio(lottoGameResult.getProfitRatio());
	}

	private List<List<Integer>> getLottoNumbersList(Money money) {
		List<List<Integer>> manualNumbersList = inputManualNumbersList(money);
		List<List<Integer>> autoNumbersList = generateAutoNumbersList(money);
		ResultView.printHowManyPurchase(manualNumbersList.size(), autoNumbersList.size());
		manualNumbersList.addAll(autoNumbersList);
		ResultView.printLottos(manualNumbersList);
		return manualNumbersList;
	}

	private List<List<Integer>> inputManualNumbersList(Money money) {
		int numberOfManual = InputView.inputManualPurchaseNumber();
		money.purchaseLotto(numberOfManual);
		return InputView.inputManualNumbersList(numberOfManual);
	}

	private List<List<Integer>> generateAutoNumbersList(Money money) {
		return NumberUtil.getRandomLottoNumbersList(money.howManyPurchase());
	}
}