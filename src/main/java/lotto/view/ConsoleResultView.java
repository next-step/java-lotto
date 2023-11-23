package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Ranking;

public class ConsoleResultView implements ResultView {
    @Override
    public void lottos(Lottos lottos) {
        for (Lotto lotto : lottos.lottos()) {
            System.out.println(lotto.lotto());
        }
        System.out.println();
    }

    @Override
    public void winningStats(Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("당첨 통계")
                .append("\n")
                .append("--------")
                .append("\n");
        for (Ranking ranking : Ranking.ranked()) {
            stringBuilder
                    .append(ranking.matchingCount())
                    .append("개 일치(").append(ranking.profit()).append("원)- ")
                    .append(lottos.countByRanking(ranking)).append("개").append("\n");
        }
        System.out.println(stringBuilder);
    }
}
