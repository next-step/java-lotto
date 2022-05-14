package lotto.view;

import lotto.domain.LotteryGames;
import lotto.domain.WinningResult;

import java.util.Map;

public class ResultView {

    public static void print(LotteryGames purchasedLottery) {
        System.out.println(purchasedLottery);
    }

    public static void printResult(Map<Integer, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Integer result : results.keySet()) {
            System.out.println(result + "개 일치 (" + WinningResult.prize(result)+ "원)- " + results.get(result) + "개");
        }
    }
    public static void printProfit(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
