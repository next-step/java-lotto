package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Winners;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class OutputView {
    public static final int SUBSTRING_INDEX = 1;
    public static final int MINIMUM_PRIZE = 3;
    public static final int MAXIMUM_PRIZE = 6;
    public static final double PROFIT_CONDITION = 1.0;

    public static void printLottoQuantity(Money money) {
        System.out.println(money.getLottoQuantity() + "개를 구매했습니다.");
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
        for (int i = MINIMUM_PRIZE; i <= MAXIMUM_PRIZE; i++) {
            System.out.println(i + "개 일치 (" + resultMap.getPrize(i) + ")- " + resultMap.getWinnersCount(i) + "개");
        }
    }

    private static void printProfit(Winners resultMap, Money lottoAmount) {
        double profit = resultMap.getProfit(lottoAmount);

        DecimalFormat form = new DecimalFormat("#.##");
        form.setRoundingMode(RoundingMode.DOWN);

        System.out.print("총 수익률은 " + form.format(profit) + "입니다.");

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
