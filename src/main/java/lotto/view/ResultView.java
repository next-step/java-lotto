package lotto.view;

import lotto.domain.*;

import java.math.BigInteger;
import java.util.*;
import static lotto.view.ResultViewConfig.*;

public class ResultView {

    private ResultView() {}

    public static void printLottoResult(Lottos lottos) {
        printBuyLottoCount(lottos);
        lottoResult(lottos.getLottos());
        System.out.println();
    }

    public static void printLottoWinningStatistics(LottoWinningResults lottoWinningResults,int price, BigInteger profit) {
        System.out.print(WINNING_STATISTICS);
        for(LottoWinningResult winningResult : lottoWinningResults.getLottoWinningResults()) {
            LottoResult result = winningResult.getLottoResult();
            System.out.printf(
                    WINNING_STATISTICS_GRID,
                    result.getWinningCount(),
                    result == LottoResult.SECOND?WINNING_STATISTICS_BONUS_GRID:"",
                    result.getPrize(),
                    winningResult.getCount()
            );
        }
        printProfit(price,profit);
    }

    private static void printProfit(int price, BigInteger profit) {
        BigInteger priceInteger = new BigInteger(String.valueOf(price));
        double result = profit.doubleValue() / priceInteger.doubleValue();
        boolean isProfit = result >= 1;
        System.out.printf(
                WINNING_STATISTICS_RESULT,
                Math.round(result * 100) / 100.0,
                isProfit ?SURPLUS:DEFICIT
        );
    }

    private static void printBuyLottoCount(Lottos lottos) {
        System.out.printf(OUTPUT_BUY_LOTTO_COUNT,lottos.getLottos().size());
    }

    private static void lottoResult(List<Lotto> lottoList) {
        lottoList.forEach(ResultView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(Arrays.toString(lotto.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber).sorted().toArray()));
    }
}
