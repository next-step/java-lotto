package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.Statistics;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final double PROFIT_PRINCIPAL_CONDITION = 1.0;

    public static void printLottoQuantity(Money money, Money lottoFee) {
        System.out.println((int) money.division(lottoFee) + "개를 구매했습니다.");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(System.out::println);
    }

    public static void printStatisticsResult(Statistics statistics, List<Lotto> lottoList) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("===============");
        printStatistics(statistics.statisticsWinner());
    }

    private static void printStatistics(Map<Prize, Long> statisticsMap) {
        statisticsMap.forEach((prize, result) -> System.out.println(prize.getMatchingCount() + "개 일치 (" + prize.getPrizeMoney() + "원)- " + result + "개"));
    }

    public static void printProfit(Statistics statistics, List<Lotto> lottoList, Money money) {
        double profit = statistics.getProfit(money);

        String profitFormat = String.format("%.2f", profit);

        System.out.print("총 수익률은 " + profitFormat + "입니다.");

        printRealProfit(profit);
        printStandardProfit(profit);
        printLoseProfit(profit);
    }

    private static void printRealProfit(double profit) {
        if (profit > PROFIT_PRINCIPAL_CONDITION) {
            System.out.println("(축하드립니다~ 이득 입니다 :) )");
        }
    }

    private static void printStandardProfit(double profit) {
        if (profit == PROFIT_PRINCIPAL_CONDITION) {
            System.out.println("(본전이네요 :( )");
        }
    }

    private static void printLoseProfit(double profit) {
        if (profit < PROFIT_PRINCIPAL_CONDITION) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임 :( )");
        }
    }
}
