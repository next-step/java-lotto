package lotto;

import java.util.List;

import lotto.domain.LottoGame;
import lotto.domain.RandomNumberStrategy;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
	public static void main(String[] args){
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();
		RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
		LottoGame lottoGame = new LottoGame(inputView.inputMoney());
		resultView.printOfBuyLotto(lottoGame, randomNumberStrategy);
		WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumber(), inputView.inputBonusNumber());
		List<Rank> userLottoRanks = lottoGame.match(winningLotto);
		resultView.printWinningResult(userLottoRanks);
		resultView.printProfit(lottoGame.calculateProfit(userLottoRanks));
	}

}
