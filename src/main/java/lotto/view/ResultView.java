package lotto.view;

import lotto.domain.*;

public class ResultView {
    public static void printResultBuyCount(long purchaseCount) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);
    }

    public static void printLottos(Lottos lottos) {
        printResultBuyCount(lottos.size());
        System.out.println(lottos.toDto());
    }

    public static void printWinningMatchCount(RankResult rankResult, Money buyAmount) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        System.out.println(rankResult.toDto());
        printRateOfEarning(rankResult.calculateRateOfEarning(buyAmount));
    }

    public static void printRateOfEarning(double rateOfEarning) {
        String message = "총 수익률은 %.2f입니다.";
        if (rateOfEarning < 1) {
            message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        System.out.printf(message, rateOfEarning);
    }
}
