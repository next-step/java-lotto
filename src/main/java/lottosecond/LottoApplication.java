package lottosecond;

import lottosecond.domain.LottoNumberShuffle;
import lottosecond.domain.Lottos;
import lottosecond.ui.InputView;
import lottosecond.ui.ResultView;

public class LottoApplication {

	public static void main(String[] args) {

		int money = InputView.inputMoney();
		Lottos lottos = new Lottos(money, new LottoNumberShuffle());

		ResultView.printLottos(lottos);

		String winningNumbers = InputView.inputLastWinningNumbers();
		int bonusNumber = InputView.inputBonusNumber();

		ResultView.printResult(lottos, winningNumbers, bonusNumber);

	}

}
