package lotto;

import lotto.controller.LottoGame;
import lotto.domain.LotteryResults;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
	public static void main(String[] args) {
		int money = InputView.inputMoney();
		LottoGame lottoGame = new LottoGame();
		Lottos lottos = lottoGame.buyLotto(money);
		ResultView.outputBuyLotto(lottos);

		String inputNumbers = InputView.inputWinningNumbers();
		LotteryResults results = lottoGame.draw(lottos, inputNumbers);

		ResultView.outputWinningStatistics(results);
	}
}