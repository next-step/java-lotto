package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView extends BaseView {

    public static void printLottos(int manualLottoCount, int autoLottoCount, Lottos lottos) {
        printlnMessageAfterNewLine(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottoCount, autoLottoCount));
        for (Lotto lotto : lottos.getLottos()) {
            printlnMessage(prettyString(lotto));
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
        printlnMessageAfterNewLine("당첨통계");
        printlnMessage("---------");
        Map<Rank, Integer> LottoPrizeResult = lottoStatistics.getLottoPrizeResult();
        Arrays.stream(Rank.values())
                .filter(prize -> !prize.equals(Rank.MISS))
                .forEach(prize -> System.out.println(prettyString(prize, LottoPrizeResult.get(prize))));
        printRevenueRate(lottoStatistics.getRevenueRate());
    }

    private static String prettyString(Rank rank, Integer prizeCount) {
        return String.format("%s- %d개", rank.getMessage(), prizeCount);
    }

    private static void printRevenueRate(BigDecimal revenueRate) {
        printlnMessage("총 수익률은 " + revenueRate + "입니다.");
        if (revenueRate.intValue() < 1) {
            printlnMessage("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        if (revenueRate.intValue() > 1) {
            printlnMessage("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
        }
    }
}
