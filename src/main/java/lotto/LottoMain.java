package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumbers;
import lotto.strategy.ListMixStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.requestPurchaseAmount();
        int ticketNumber = amount / 1000;

        LottoGame lottoGame = new LottoGame();
        lottoGame.purchase(ticketNumber, new ListMixStrategy());

        LottoNumbers winnerNumbers = InputView.requestWinnerNumbers();
        lottoGame.drawLotto(winnerNumbers);

        ResultView.printWinners(lottoGame);
        ResultView.printYield(lottoGame, amount);
    }
}
