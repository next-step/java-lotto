package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ResultView {
    public void printLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.values().forEach(lotto -> System.out.println(lotto.numbers()));
    }

    public void printStatistics(WinningStatistics stats, Money money) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(Rank.winningRanks())
            .sorted(Comparator.comparingInt(Rank::displayOrder))
            .forEach(rank -> printRank(stats, rank));

        System.out.println("총 수익률은 " + stats.profitRate(money) + "입니다.");
    }

    private void printRank(WinningStatistics stats, Rank rank) {
        System.out.println(rank.description() + " (" + rank.prize() + "원)- " + stats.countOf(rank) + "개");
    }
}
