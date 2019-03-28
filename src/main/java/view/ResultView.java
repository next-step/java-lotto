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
        PROFIT_VALUE.put(LottoProfit.FOURTH.getNumberOfMatch(), LottoProfit.FOURTH.getPrizeMoney());
        PROFIT_VALUE.put(LottoProfit.THIRD.getNumberOfMatch(), LottoProfit.THIRD.getPrizeMoney());
        PROFIT_VALUE.put(LottoProfit.SECOND.getNumberOfMatch(), LottoProfit.SECOND.getPrizeMoney());
        PROFIT_VALUE.put(LottoProfit.FIRST.getNumberOfMatch(), LottoProfit.FIRST.getPrizeMoney());
    }

    public static void printWinningStatistics(LottoGameResult result){
        System.out.println("당첨 통계\n-----------");
        Iterator<Integer> keys = result.getGameResult().keySet().iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            System.out.println(key + "개 일치 (" + PROFIT_VALUE.get(key) +
                    ")원 - " + result.getGameResult().get(key) + "개");
        }
    }

    public static void printProfitRate(LottoGameResult result, int inputMoney){
        double totalProfit = 0.0;

        Iterator<Integer> keys = result.getGameResult().keySet().iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            totalProfit += (double) PROFIT_VALUE.get(key) * result.getGameResult().get(key);
        }

        System.out.println("총 수익률은 " + totalProfit / (double) inputMoney + "입니다.");
    }

}
