package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameResults;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.Map;

public class LottoMain {

    public static void main(String[] args){

        int gameMoney = InputView.getInputMoneyAmount();

        LottoGame lottoGame = new LottoGame(gameMoney);
        LottoGameResults lottoGameResults = lottoGame.start();

        ResultView.getLottoTickets(lottoGameResults);



        String lastWinningNumbers = InputView.getInputWinningNumbers();

        lottoGameResults.checkWinningResult(lastWinningNumbers);

        Map<Integer, Integer> resultsMap = lottoGameResults.getWinningResultRecord();

        ResultView.getPrizeResult(resultsMap);



        double profit = lottoGameResults.getProfit(resultsMap);

        ResultView.getProfitResult(profit);


    }
}
