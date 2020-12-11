package step2;

import step2.domain.LottoGame;
import step2.domain.WinningLottery;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoGame lottoGame;

        inputView.init();
        inputView.showInputMessage();
        int money = inputView.getPurchaseAmount();
        lottoGame = new LottoGame(money);

        resultView.showPurchasedLottery(lottoGame.getLotteryList());
        inputView.showInputWinningMessage();

        String[] winningNumbers = inputView.getWinningNumbers();
        WinningLottery winningLottery = new WinningLottery(winningNumbers);

    }
}
