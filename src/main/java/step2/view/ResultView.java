package step2.view;

import step2.domain.Lotteries;
import step2.domain.Statistics;

import java.util.stream.Collectors;

public class ResultView {
    public static void printLotteries(Lotteries lotteries) {
        lotteries.getList().forEach(l -> {
            String lotteryNumbers = l.getList().stream()
                    .map(n -> String.valueOf(n.getNumber()))
                    .collect(Collectors.joining(", "));

            System.out.println(String.format("[%s]", lotteryNumbers));
        });

        System.out.println();
    }

    public static void printStatistics(Statistics statistic) {
        System.out.println("\n당첨 통계");

        statistic.getStatistics().forEach((ranking, count) -> {
            System.out.println(String.format("%s개 일치 (%d원) - %d개", ranking.getCorrectCount(), ranking.getPrizeMoney(), count));
        });
    }

    public static void printProfitRate(double profitRate) {
        System.out.println(String.format("총 수익률은 %.0f%% 입니다.", profitRate));
    }
}
