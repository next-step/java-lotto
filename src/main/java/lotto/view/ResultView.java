package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.Rank;

import java.util.List;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.getSize()).append("개를 구매했습니다.\n");
        for (Lotto lotto : lottos.values()) {
            sb.append(lotto.combine(", "));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void printReport(Lottos lottos, Lotto winningNumbers, Number bonusNumber) {
        List<Rank> ranks = lottos.getRanks(winningNumbers, bonusNumber);

        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        for (Rank rank : Rank.values()) {
            sb.append(rank.countOfMatch()).append("개 일치");
            if (rank.equals(Rank.SECOND)) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (")
                .append(rank.winningMoney())
                .append("원)- ")
                .append(ranks.stream()
                        .filter(r -> r.equals(rank))
                        .count())
                .append("개)\n");
        }

        sb.append("총 수익률은 ").append(lottos.calculateROI(ranks)).append("입니다\n");
        System.out.println(sb);
    }
}
