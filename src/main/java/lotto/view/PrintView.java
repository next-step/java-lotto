package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.RankCounts;

public class PrintView {

    private PrintView() {}

    public static void printNumberOfLotto(final int size) {
        System.out.printf("%d개를 구매했습니다.\n", size);
    }

    public static void printLottoNumber(final Lottos lottos) {
        lottos.get().forEach(lotto -> System.out.println(lotto.get()));
    }

    public static void printRankCounts(final RankCounts rankCounts) {
        rankCounts.get().forEach((rank, rankCount) -> {
            StringBuilder sentence = new StringBuilder();

            sentence.append(rank.getMatchCount())
                    .append("개 일치");
            if (rank == LottoRank.SECOND) {
                sentence.append(", 보너스 볼 일치");
            }
            sentence.append(String.format(" (%d원) - %d개", rank.getAmount(), rankCount));
            System.out.println(sentence);
        });
    }

    public static void printProfitRate(final double profitRatio) {
        System.out.printf("총 수익률은 %.2f 입니다. (기준:1)\n", profitRatio);
    }
}
