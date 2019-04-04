package view;

import domain.Lotto;
import domain.LottoGameResult;
import domain.LottoProfit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ResultView {

    private final static Map<Integer, Integer> PROFIT_VALUE = new HashMap<>();
    static {
        PROFIT_VALUE.put(LottoProfit.MISS.getNumberOfMatch(), LottoProfit.MISS.getPrizeMoney());
        PROFIT_VALUE.put(LottoProfit.FIFTH.getNumberOfMatch(), LottoProfit.FIFTH.getPrizeMoney());
        PROFIT_VALUE.put(LottoProfit.FOURTH.getNumberOfMatch(), LottoProfit.FOURTH.getPrizeMoney());
        PROFIT_VALUE.put(LottoProfit.THIRD.getNumberOfMatch(), LottoProfit.THIRD.getPrizeMoney());
        PROFIT_VALUE.put(LottoProfit.SECOND.getNumberOfMatch(), LottoProfit.SECOND.getPrizeMoney());
        PROFIT_VALUE.put(LottoProfit.FIRST.getNumberOfMatch(), LottoProfit.FIRST.getPrizeMoney());
    }

    public static void printWinningStatistics(LottoGameResult result){
        System.out.println("당첨 통계\n-----------");

        for (LottoProfit profit : LottoProfit.values()) {
            int key = profit.getNumberOfMatch();
            System.out.println(profit.getNumberOfMatch() + "개 일치 (" + profit.getPrizeMoney() +
                    ")원 - " + result.getFrequencyOfResult(profit) + "개");
        }
    }

    public static void printProfitRate(LottoGameResult result, int inputMoney){
        double totalProfit = 0.0;

        for (LottoProfit profit : LottoProfit.values()) {
            int key = profit.getNumberOfMatch();
            totalProfit += (double) result.getFrequencyOfResult(profit) * profit.getPrizeMoney();
        }

        System.out.println("총 수익률은 " + totalProfit / (double) inputMoney + "입니다.");
    }

}
