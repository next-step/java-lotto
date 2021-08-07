package lottosecond;

import lottosecond.domain.LottoNumberShuffle;
import lottosecond.domain.Lottos;
import lottosecond.ui.InputView;
import lottosecond.ui.ResultView;

public class LottoApplication {

	public static void main(String[] args) {
		InputView inputView = new InputView();

		Lottos lottos = new Lottos(inputView.getMoney(), new LottoNumberShuffle());

		ResultView resultView = new ResultView();
		resultView.printLottos(lottos);

		String winningNumbers = inputView.inputLastWinningNumbers();
		int bonusNumber = inputView.inputBonusNumber();

		resultView.printResult(lottos, winningNumbers, bonusNumber);
	}
}
