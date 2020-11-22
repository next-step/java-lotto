package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameResults;
import lotto.domain.WinResult;
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
        return lottoGame.issueLottoTicket();
    }

    public static String getLastWinningNumbers() {
        return  InputView.getInputWinningNumbers();
    }

    public static String getLastBonusNumber() {
        return  InputView.getInputBonusNumber();
    }

    public static void getPrizeResult(LottoGameResults lottoGameResults, String lastWinningNumbers, String bonusNumber) {

        lottoGameResults.checkWinningResult(lastWinningNumbers, bonusNumber);

        Map<WinResult, Integer> resultsMap = lottoGameResults.getWinningResultRecord();

        getPrizeResult(resultsMap);

        double profit = lottoGameResults.getProfit(resultsMap);

        getProfitResult(profit);

    }

    private static void getProfitResult(double profit) {
        ResultView.getProfitResult(profit);
    }

    private static void getPrizeResult(Map<WinResult, Integer> resultsMap) {
        ResultView.getPrizeResult(resultsMap);
    }

}
