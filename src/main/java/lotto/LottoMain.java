package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameResults;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.Map;

public class LottoMain {

    public static void main(String[] args){

        int gameMoney = InputView.getInputMoneyAmount();

        LottoGame lottoGame = new LottoGame(gameMoney);
        LottoGameResults lottoGameResults = lottoGame.start();

        lottoGameResults.getLottoGameResults()
                .stream().forEach(lottoGameResult -> System.out.println(Arrays.toString(lottoGameResult.getLottoGameResult().toArray())));

        String lastWinningNumbers = InputView.getInputWinningNumbers();

        lottoGameResults.checkWinningResult(lastWinningNumbers);

        Map<Integer, Integer> resultsMap = lottoGameResults.getWinningResultRecord();

        System.out.println("3개맞음:"+resultsMap.get(3));
        System.out.println("4개맞음:"+resultsMap.get(4));
        System.out.println("5개맞음:"+resultsMap.get(5));
        System.out.println("6개맞음:"+resultsMap.get(6));

        double profit = lottoGameResults.getProfit(resultsMap);
        System.out.println("수익률:"+profit);

    }
}
