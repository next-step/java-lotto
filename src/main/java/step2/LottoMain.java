package step2;

import step2.domain.LottoGame;
import step2.domain.Money;
import step2.domain.WinningLottery;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.init();
        inputView.printInputMessage();

        int amount = inputView.getPurchaseAmount();
        Money money = new Money(amount);

        LottoGame lottoGame = new LottoGame(money);

        resultView.printNumberOfPurchased(lottoGame.getLotteryListSize());
        resultView.printPurchasedLotteries(lottoGame.getLotteryList());

        inputView.printInputWinningMessage();

        String winningNumbers = inputView.getWinningNumbers();
        lottoGame.matchLottery(lottoGame.getLotteryList(), new WinningLottery(winningNumbers));

        resultView.printResult(
                lottoGame.getMatchedResult(),
                lottoGame.calculateProfitRate(money.getMoney(), lottoGame.getProfit())
        );
    }
}
