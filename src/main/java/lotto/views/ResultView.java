package lotto.views;

import java.util.Arrays;
import lotto.domains.LottoStatistics;
import lotto.domains.Prize;

public class ResultView {
    private final LottoStatistics statistics;

    public ResultView(LottoStatistics lottoStatistics) {
        this.statistics = lottoStatistics;
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---------");

        printCountEachPrize(statistics);

        System.out.printf("총 수익률은 %.2f입니다.", statistics.getYield());
        System.out.println();
    }

    private void printCountEachPrize(LottoStatistics statistics) {
        Arrays.stream(Prize.values())
                .filter(Prize::isWin)
                .forEach(prize -> printPrize(prize, statistics));
    }

    private void printPrize(Prize prize, LottoStatistics statistics) {
        System.out.printf("%d개 일치 (%d원)- %d개",
                prize.getCorrectCount(),
                prize.getReward(),
                statistics.getWinningCount(prize));
        System.out.println();
    }
}
