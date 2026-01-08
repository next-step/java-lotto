package lotto.ui;

import java.util.Arrays;
import java.util.Comparator;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public class ResultView {
    public void printPurchaseSummary(int manualCount, int autoCount) {
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "장을 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        // 기존 출력 규칙이 따로 있으면 여기만 맞추면 됨
        lottos.values().forEach(lotto -> System.out.println(lotto.numbers()));
    }

    public void printStatistics(WinningStatistics stats) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(Rank.winningRanks())
            .sorted(Comparator.comparingInt(Rank::displayOrder))
            .forEach(rank -> printRank(stats, rank));
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    private void printRank(WinningStatistics stats, Rank rank) {
        System.out.println(rank.description() + " (" + rank.prize() + "원)- " + stats.countOf(rank) + "개");
    }
}
