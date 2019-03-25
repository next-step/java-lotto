package lotto.view;

import lotto.domain.Lotteries;
import lotto.domain.LotteryMachine;

import java.util.Map;

public class ProfitRate {

    public static void printStatistics(Lotteries lotteries, LotteryMachine lotteryMachine) {
        System.out.println("당첨 통계");

        Map<String, Integer> ranks = lotteries.makeAllLotteriesRank(lotteryMachine);

        System.out.println("3개 일치 (5000원) " + ranks.get("fourth"));
        System.out.println("4개 일치 (50000원) " + ranks.get("third"));
        System.out.println("5개 일치 (150000원) " + ranks.get("second"));
        System.out.println("6개 일치 (2000000000) " + ranks.get("first"));

        System.out.println("총 수익률은 " + lotteries.calculateProfit(lotteryMachine) + " 입니다.");
    }
}
