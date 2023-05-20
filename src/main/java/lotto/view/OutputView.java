package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.Statistics;
import lotto.model.LottoInformation;

import java.util.List;

public class OutputView {

    private static final double PROFIT_PRINCIPAL_CONDITION = 1.0;

    public static void printLottoQuantity(Money manualPurchaseAmount, Money autoPurchaseAmount) {

        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n",
                calculateLottoAmountBy(manualPurchaseAmount), calculateLottoAmountBy(autoPurchaseAmount));
    }

    public static void printLottoList(Lotto lotto) {
        System.out.println(lotto);
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

    public static void printProfit(Statistics statistics) {
        double profit = statistics.provideProfit();

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

    private static long calculateLottoAmountBy(Money money) {
        return Math.floorDiv(money.getAmount(), LottoInformation.LOTTO_UNIT_PRICE);
    }
}
