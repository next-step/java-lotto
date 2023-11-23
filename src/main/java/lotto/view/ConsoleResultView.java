package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Ranking;

public class ConsoleResultView implements ResultView {
    @Override
    public void lottos(Lottos lottos) {
        lottos.lottos().forEach(lotto -> System.out.println(lotto.lotto()));
//        for (Lotto lotto : lottos.lottos()) {
//            System.out.println(lotto.lotto());
//        }
        System.out.println();
    }

    @Override
    public void winningStats(Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("당첨 통계").append("\n").append("--------").append("\n");

        for (Ranking ranking : Ranking.ranked()) {
            stringBuilder
                    .append(ranking.matchingCount()).append("개 일치(").append(ranking.profit()).append("원)- ")
                    .append(lottos.countByRanking(ranking)).append("개").append("\n");
        }

        stringBuilder.append("총 수익률은 ").append(lottos.profitRate()).append("입니다.");

        if (lottos.isLoss()) {
            stringBuilder.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임.)");
        }
        System.out.println(stringBuilder);
    }
}
