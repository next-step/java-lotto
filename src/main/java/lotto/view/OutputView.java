package lotto.view;

import lotto.domain.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {
    private static final int SUBSTRING_INDEX = 1;
    private static final double PROFIT_CONDITION = 1.0;


    public static void printLottoQuantity(Amount manualAmount, Amount autoAmount) {
        System.out.println();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n",
                manualAmount.getAmount(), autoAmount.getAmount());
    }

    public static void printLottos(Lottos lottos) {
        String viewLottos = lottos.toString()
                .substring(SUBSTRING_INDEX, lottos.toString().length() - SUBSTRING_INDEX)
                .replace("\\+s[", "[")
                .replace("], ", "]\n");

        System.out.println(viewLottos);
        System.out.println();
    }

    public static void printResult(Winners resultMap, Money lottoAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("===============");
        printStatistics(resultMap);
        printProfit(resultMap, lottoAmount);
    }

    private static void printStatistics(Winners resultMap) {
        List<Statistics> statistics = Arrays.asList(Statistics.values());
        Collections.reverse(statistics);

        for (Statistics statistic : statistics) {
            String matchingNumber = statistic.getMatchingBall() + "개 일치";
            String prize = "(" + statistic.getPrize() + "원)- ";
            String resultCount = resultMap.getWinnersMatchingCount(statistic) + "개";

            if (statistic == Statistics.SECOND) {
                System.out.println(matchingNumber + ", 보너스 볼 일치" + prize + resultCount);
            } else if (statistic != Statistics.MISS){
                System.out.println(matchingNumber + prize + resultCount);
            }
        }
    }

    private static void printProfit(Winners resultMap, Money lottoAmount) {
        double profit = resultMap.getProfit(lottoAmount);

        DecimalFormat form = new DecimalFormat("#.##");
        form.setRoundingMode(RoundingMode.DOWN);

        System.out.printf("총 수익률은 %s입니다.",  form.format(profit));

        printRealProfit(profit);
        printStandardProfit(profit);
        printLoseProfit(profit);
    }

    private static void printRealProfit(double profit) {
        if (profit > PROFIT_CONDITION) {
            System.out.println("(축하드립니다~ 개이득!)");
        }
    }

    private static void printStandardProfit(double profit) {
        if (profit == PROFIT_CONDITION) {
            System.out.println("(본전이네요.)");
        }
    }

    private static void printLoseProfit(double profit) {
        if (profit < PROFIT_CONDITION) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
