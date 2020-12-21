package step2;

import step2.domain.Lottery;
import step2.domain.LottoGame;
import step2.domain.WinningLottery;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.init();
        inputView.showInputMessage();
        int money = inputView.getPurchaseAmount();
        LottoGame lottoGame = new LottoGame(money);

        resultView.showPurchasedLottery(lottoGame.getLotteryList());
        inputView.showInputWinningMessage();

        String winningNumbers = inputView.getWinningNumbers();

        WinningLottery winningLottery = new WinningLottery(winningNumbers);

        Map<Lottery, Integer> matchedResult = lottoGame.matchLottery(lottoGame.getLotteryList(),winningLottery);
        float profitRate = lottoGame.calculateProfit(money, matchedResult);

        resultView.showResult(matchedResult, profitRate);
    }
}
