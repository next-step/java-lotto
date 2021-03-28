package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoStatistics;
import step2.domain.Lottos;
import step2.domain.Number;
import step2.domain.Prize;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static void printLottos(Lottos lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.getLottoCount()));
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(prettyString(lotto));
        }
    }

    private static String prettyString(Lotto lotto) {
        return String.format("%s%s%s", "[",
                        lotto.getNumbers()
                                .stream()
                                .map(Number::getNumber)
                                .sorted()
                                .map(i -> String.valueOf(i))
                                .collect(Collectors.joining(", ")),
                "]");
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("\n당첨통계");
        System.out.println("---------");
        Map<Prize, Integer> LottoPrizeResult = lottoStatistics.getLottoPrizeResult();
        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.FAIL))
                .forEach(prize -> System.out.println(prettyString(prize, LottoPrizeResult.get(prize))));
    }

    private static String prettyString(Prize prize, Integer prizeCount) {
        return String.format("%s- %d개", prize.getMessage(), prizeCount);
    }

    public static void printRevenueRate(BigDecimal revenueRate) {
        System.out.print("총 수익률은 " + revenueRate + "입니다.");
        if (revenueRate.intValue() < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        if (revenueRate.intValue() > 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
        }
    }
}
