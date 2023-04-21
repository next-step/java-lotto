package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Winners;

import java.util.stream.IntStream;

public class OutputView {
    public static final int ZERO = 0;
    public static final int MINIMUM_PRIZE = 3;
    public static final int MAXIMUM_PRIZE = 6;

    public static void printLottoQuantity(Money money) {
        System.out.println(money.getLottoQuantity() + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        IntStream.range(ZERO, lottos.getLottoQuantity())
                .mapToObj(lottos::getLotto)
                .forEach(System.out::println);
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
        System.out.print("총 수익률은 " + profit + "입니다.");
        if (profit > 1.0) {
            System.out.println("(축하드립니다~ 개이득!)");
        } else if (profit == 1.0) {
            System.out.println("(본전이네요.)");
        } else {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println();
    }
}
