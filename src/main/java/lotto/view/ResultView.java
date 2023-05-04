package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Match;
import lotto.domain.Matchs;

import java.util.Arrays;
import java.util.Map;

public class ResultView {
    public static void printResultBuyCount(long purchaseCount) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void printWinningMatchCount(Matchs matchs) {
        Map<Match, Long> entry = matchs.getMatchs();
        System.out.println("당첨 통계");
        System.out.println("-----------");
        for (Match match : Match.values()) {
            String message = match.getMessage();
            Long count = entry.getOrDefault(match, 0L);

            System.out.printf(message, count);
            System.out.println();
        }
    }

    public static void printRateOfEarning(double rateOfEarning) {
        String message = "총 수익률은 %.2f입니다.";
        if (rateOfEarning < 1) {
            message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        System.out.printf(message, rateOfEarning);
    }
}
