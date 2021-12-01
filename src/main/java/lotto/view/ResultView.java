package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Ranks;

import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void printView(String str) {
        System.out.println(str);
    }

    public static void printLottoNumberView(Lottos lottos) {
        lottos.getLottos().forEach(ResultView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void printWinningStatsView(Ranks ranks) {
        Map<Rank, Long> winningStatsMap = ranks.getRankCountMap();

        for (Rank rank : Rank.values()) {
            long count = winningStatsMap.getOrDefault(rank, 0L);
            printStats(rank, count);
        }
    }

    private static void printStats(Rank rank, long count) {
        String st = "%d개 일치 (%d원)- %d개";

        if (rank == Rank.SECOND) {
            st = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
        }

        if (rank != Rank.MISS) {
            System.out.printf((st) + "%n", rank.getCountOfMatch(), rank.getWinningMoney(), count);
        }
    }
}
