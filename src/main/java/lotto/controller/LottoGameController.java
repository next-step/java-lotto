package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameResults;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoGameController {

    public static int inputGameMoney() {
        return InputView.getInputMoneyAmount();
    }

    public static void showLottoTickets(LottoGameResults lottoGameResults) {
        ResultView.getLottoTickets(lottoGameResults);
    }

    public static LottoGameResults execute(int gameMoney) {
        LottoGame lottoGame = new LottoGame(gameMoney);
        return lottoGame.start();
    }

    public static String getLastWinningNumbers() {
        return  InputView.getInputWinningNumbers();
    }

    public static void getPrizeResult(LottoGameResults lottoGameResults, String lastWinningNumbers) {

        lottoGameResults.checkWinningResult(lastWinningNumbers);

        Map<Integer, Integer> resultsMap = lottoGameResults.getWinningResultRecord();

        getPrizeResult(resultsMap);

        double profit = lottoGameResults.getProfit(resultsMap);

        getProfitResult(profit);

    }

    private static void getProfitResult(double profit) {
        ResultView.getProfitResult(profit);
    }

    private static void getPrizeResult(Map<Integer, Integer> resultsMap) {
        ResultView.getPrizeResult(resultsMap);
    }
}
