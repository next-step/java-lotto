package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.result.LottoResult;

public class ResultView {

    public static void printLottoPurchase(int handLottoQuantity, int automaticLottoQuantity) {
        System.out.println("수동으로 " + handLottoQuantity + "장, 자동으로 " + automaticLottoQuantity + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            final StringBuilder sb = new StringBuilder("[");
            lotto.getNumbers().stream()
                    .map(LottoNumber::getNumber)
                    .forEach(number -> sb.append(number).append(", "));

            sb.append("]").deleteCharAt(sb.lastIndexOf(","));
            System.out.println(sb.toString().trim());
        }
        System.out.println();
    }

    public static void printResult(Map<LottoResult, Integer> numberOfResults, BigDecimal profitRate) {
        printStatistics(numberOfResults);
        printProfitRate(profitRate);
    }

    private static void printStatistics(Map<LottoResult, Integer> numberOfResults) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

        numberOfResults.keySet()
                .forEach(result -> System.out.println(
                        result.getDescription() + numberOfResults.get(result) + "개"));
    }

    private static void printProfitRate(BigDecimal profitRate) {
        System.out.println(
                "총 수익률은 " + profitRate + "입니다.");
    }

}
