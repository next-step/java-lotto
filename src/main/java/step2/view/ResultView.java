package step2.view;

import step2.domain.Lotteries;
import step2.domain.Lottery;
import step2.domain.enums.RANKING;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLotteries(Lotteries lotteries) {
        for (Lottery lottery : lotteries.getList()) {
            String str = lottery.getList().stream()
                    .map(n -> String.valueOf(n.getNumber()))
                    .collect(Collectors.joining(", "));

            System.out.println(String.format("[%s]", str));
        }

        System.out.println();
    }

    public static void printResult(Map<RANKING, Integer> result) {
        System.out.println("\n당첨 통계");
        
        for (Map.Entry<RANKING, Integer> entry : result.entrySet()) {
            System.out.println(String.format("%s개 일치 (%d원) - %d개", entry.getKey().getCorrectCount(), entry.getKey().getPrizeMoney(), entry.getValue()));
        }
    }

    public static void printStatisticRate(double profitRate) {
        System.out.println(String.format("총 수익률은 %.0f%% 입니다.", profitRate));
    }
}
