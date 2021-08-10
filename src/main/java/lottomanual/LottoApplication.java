package lottomanual;

import lottomanual.domain.Lottos;
import lottomanual.ui.InputView;
import lottomanual.ui.ResultView;

public class LottoApplication {

	public static void main(String[] args) {

		int money = InputView.inputMoney();
		String[] manualNumbers = InputView.inputManualNumbers();

		Lottos lottos = Lottos.of(money, manualNumbers);

		ResultView.printLottos(lottos, manualNumbers.length);

		String winningNumbers = InputView.inputLastWinningNumbers();
		int bonusNumber = InputView.inputBonusNumber();

		ResultView.printResult(lottos, winningNumbers, bonusNumber);

	}

}
