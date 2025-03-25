package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.Map;

public class OutputView {
    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.getLottoList().stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

    public static void printStatistics(Map<Rank, Integer> statistics) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");

        for (Rank rank : Rank.values()) {
            if(rank == Rank.PENDING) {
                continue;
            }

            int matchCount = rank.getMatchCount();
            int prize = rank.getPrize();
            int winningLottoCount = statistics.get(rank);
            String messageFormat = "%d개 일치 (%d원) - %d개";

            System.out.println(String.format(messageFormat, matchCount, prize, winningLottoCount));
        }
    }

    public static void printROI(double ROI) {
        System.out.println("총 수익률은 " + ROI + "입니다.");
    }
}
