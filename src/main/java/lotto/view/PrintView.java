package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.RankCounts;

public class PrintView {

    public static void printNumberOfLotto(int size) {
        System.out.printf("%d개를 구매했습니다.\n", size);
    }

    public static void printLottoNumber(Lottos lottos) {
        lottos.get().stream()
            .forEach(lotto -> System.out.println(lotto.get()));
    }

    public static void printRankCounts(RankCounts rankCounts) {
        rankCounts.get().entrySet().stream()
            .forEach(e -> {
                StringBuilder sentence = new StringBuilder();

                LottoRank rank = e.getKey();
                final int rankCount = e.getValue();

                sentence.append(rank.getMatchCount())
                    .append("개 일치");
                if (rank == LottoRank.SECOND) {
                    sentence.append(", 보너스 볼 일치");
                }
                sentence.append(String.format(" (%d원) - %d개", rank.getAmount(), rankCount));
                System.out.println(sentence);
            });
    }

    public static void printProfitRate(double profitRatio) {
        System.out.printf("총 수익률은 %.2f 입니다. (기준:1)\n", profitRatio);
    }
}
