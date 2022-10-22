package lotto.views;

import java.util.Arrays;
import lotto.domains.LottoStatistics;
import lotto.domains.Prize;

public class ResultView {
    public ResultView() {
    }

    public void printStatistics(LottoStatistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        printCountEachPrize(statistics);

        System.out.printf("총 수익률은 %.2f입니다.", statistics.getYield());
        System.out.println();
    }

    public void printCountEachPrize(LottoStatistics statistics) {
        Arrays.stream(Prize.values())
                .filter(Prize::isWin)
                .forEach(prize -> printPrize(prize, statistics));
    }

    public void printPrize(Prize prize, LottoStatistics statistics) {
        String normalFormat = "%d개 일치 (%d원)- %d개";
        String bonusFormat = "%d개 일치, 보너스 볼 일치(%d원)- %d개";

        System.out.printf(prize == Prize.SECOND ? bonusFormat : normalFormat,
                prize.getCorrectCount(),
                prize.getReward(),
                statistics.getWinningCount(prize));
        System.out.println();
    }
}
