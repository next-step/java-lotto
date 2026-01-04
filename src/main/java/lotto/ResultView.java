package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ResultView {
    public void printPurchaseSummary(int manualCount, int autoCount) {
        System.out.println();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualCount, autoCount);
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.values()) {
            System.out.println(lotto.numbers());
        }
    }

    public void printStatistics(WinningStatistics stats) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        printRank(stats, Rank.FIFTH);
        printRank(stats, Rank.FOURTH);
        printRank(stats, Rank.THIRD);
        printRank(stats, Rank.SECOND);
        printRank(stats, Rank.FIRST);
    }

    private void printRank(WinningStatistics stats, Rank rank) {
        System.out.printf("%s- %d개%n", rank.label(), stats.countOf(rank));
    }

    public void printProfitRate(double rate) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", rate);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
