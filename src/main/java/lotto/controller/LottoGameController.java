package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameResults;
import lotto.domain.LottoNumber;
import lotto.domain.PrizeUnit;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGameController {

    public static int inputGameMoney() {
        return InputView.getInputMoneyAmount();
    }

    public static void showLottoTickets(LottoGameResults lottoGameResults) {
        ResultView.showLottoTickets(lottoGameResults);
    }

    public static LottoGameResults execute(int gameMoney, List<List<LottoNumber>> manualTicket) {
        LottoGame lottoGame = new LottoGame(gameMoney);
        return lottoGame.issueLottoTicket(manualTicket);
    }

    public static String getLastWinningNumbers() {
        return  InputView.getInputWinningNumbers();
    }

    public static String getLastBonusNumber() {
        return  InputView.getInputBonusNumber();
    }

    public static void getPrizeResult(LottoGameResults lottoGameResults, String lastWinningNumbers, String bonusNumber) {

        lottoGameResults.checkWinningResult(parseLastWinningNumber(lastWinningNumbers), parseBonusNumber(bonusNumber));

        Map<PrizeUnit, Integer> resultsMap = lottoGameResults.getWinningResultRecord();

        getPrizeResult(resultsMap);

        double profit = lottoGameResults.getProfit(resultsMap);

        getProfitResult(profit);

    }

    public static LottoNumber parseBonusNumber(String bonusNumber) {
        return InputView.parseBonusNumber(bonusNumber);
    }

    public static List<LottoNumber> parseLastWinningNumber(String lastWinningNumbers) {
        return InputView.splitLastWinningNumbers(lastWinningNumbers);
    }

    private static void getProfitResult(double profit) {
        ResultView.showProfitResult(profit);
    }

    private static void getPrizeResult(Map<PrizeUnit, Integer> resultsMap) {
        ResultView.showPrizeResult(resultsMap);
    }

    public static int inputManualTicketCount(int gameMoney) {
        return InputView.getManualLottoTicketCount(gameMoney);
    }

    public static List<List<LottoNumber>> inputManualTicket(int manualTicketCount) {
        if(manualTicketCount == 0){
            return new ArrayList<>();
        }
        return InputView.getManualLottoNumbers(manualTicketCount);
    }


}
