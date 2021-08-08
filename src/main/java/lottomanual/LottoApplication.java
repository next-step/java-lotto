package lottomanual;

import lottomanual.domain.LottoNumberShuffle;
import lottomanual.domain.Lottos;
import lottomanual.ui.InputView;
import lottomanual.ui.ResultView;

public class LottoApplication {

	public static void main(String[] args) {

		int money = InputView.inputMoney();
		Lottos lottos = new Lottos(money, LottoNumberShuffle.generate());

		ResultView.printLottos(lottos);

		String winningNumbers = InputView.inputLastWinningNumbers();
		int bonusNumber = InputView.inputBonusNumber();

		ResultView.printResult(lottos, winningNumbers, bonusNumber);

	}

}
