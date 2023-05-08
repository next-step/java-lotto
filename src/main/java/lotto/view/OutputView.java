package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.Statistics;

import java.util.List;

public class OutputView {

    private static final double PROFIT_PRINCIPAL_CONDITION = 1.0;

    public static void printLottoQuantity(Lotto lotto) {
        System.out.println(lotto.getLottoNumbersSize() + "개를 구매했습니다.");
    }

    public static void printLottoList(Lotto lotto) {
        lotto.showLottoNumbers();
    }

    public static void printStatisticsResult(Statistics statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("===============");
        printStatistics(statistics);
    }

    private static void printStatistics(Statistics statistics) {

        List<Prize> prizeList = Prize.extractDisplayPrize();

        prizeList.forEach(prize -> {
            String prompt = prize.getDisplayPrompt()
                    + "-"
                    + statistics.getWinnersMatchingCount(prize)
                    + "개";
            System.out.println(prompt);
        });
    }

    public static void printProfit(Statistics statistics, Money money) {
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
