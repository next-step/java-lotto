package view;

import domain.LottoGameResult;
import domain.LottoMoney;
import domain.LottoProfit;

public class ResultView {

    public static void printWinningStatistics(LottoGameResult result){
        System.out.println("당첨 통계\n-----------");

        for (LottoProfit profit : LottoProfit.values()) {
            int key = profit.getNumberOfMatch();
            System.out.println(profit.getNumberOfMatch() + "개 일치 (" + profit.getPrizeMoney() +
                    ")원 - " + result.getWinningCountOfResult(profit) + "개");
        }
    }

    public static void printProfitRate(LottoGameResult result, LottoMoney money){
        System.out.println("총 수익률은 " + result.getProfitRate(money) + "입니다.");
    }

}
