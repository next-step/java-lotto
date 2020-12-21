package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoStarter {
	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame();
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();
		int buyMoney = inputView.printBuyMoneyMessageAndReturnInput();
		int lottoGameCount = lottoGame.calculateLottoCount(buyMoney);
		resultView.printLottoGameCount(lottoGameCount);
		LottoNumbers lottoNumbers = lottoGame.generateLottoNumbers(lottoGameCount, new LottoNumberGenerator());
		resultView.printLottoNumbers(lottoNumbers);
	}
}
