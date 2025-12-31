package lotto;

import java.util.List;

public class ResultView {
    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.numbers()));
    }

    public void printStatistics(WinningStatistics stats, Money money) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : Rank.winningRanks()) {
            System.out.println(rank.description() + " (" + rank.prize() + "원)- "
                + stats.countOf(rank) + "개");
        }

        System.out.println("총 수익률은 " + stats.profitRate(money) + "입니다.");
    }
}
