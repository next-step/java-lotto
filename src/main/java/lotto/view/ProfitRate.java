package lotto.view;

import lotto.domain.TotalLotteries;
import lotto.domain.WinnerLottery;

import java.util.Map;

public class ProfitRate {

    public static void printStatistics(TotalLotteries totalLotteries, WinnerLottery winnerLottery) {
        System.out.println("당첨 통계");

        Map<String, Integer> ranks = totalLotteries.makeAllLotteriesRank(winnerLottery);

        System.out.println("3개 일치 (5000원) " + ranks.get("fifth"));
        System.out.println("4개 일치 (50000원) " + ranks.get("fourth"));
        System.out.println("5개 일치 (150000원) " + ranks.get("third"));
        System.out.println("5개 일치, 보너스 볼 일치 (3000000원) " + ranks.get("second"));
        System.out.println("6개 일치 (2000000000원) " + ranks.get("first"));

        System.out.println("총 수익률은 " + totalLotteries.calculateProfit(winnerLottery) + " 입니다.");
    }
}
