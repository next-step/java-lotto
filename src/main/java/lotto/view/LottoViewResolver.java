package lotto.view;

import lotto.data.Lottos;
import lotto.data.Rank;
import lotto.data.Winners;

public class LottoViewResolver {
    private final Viewer viewer;

    public LottoViewResolver(Viewer viewer) {
        this.viewer = viewer;
    }

    public void viewStart(Lottos lottos) {
        StringBuilder sb = new StringBuilder();

        resolveStartMessages(lottos, sb);

        viewer.view(sb.toString());
    }

    public void viewResult(Winners winners, long totalSpent) {
        StringBuilder sb = new StringBuilder();

        resolveResultMessages(winners, sb, totalSpent);

        viewer.view(sb.toString());
    }

    private void resolveResultMessages(Winners winners, StringBuilder sb, long totalSpent) {
        sb.append("결과 확인: \n");
        sb.append(winnerResult(winners)).append("\n");
        sb.append("총 수익률: \n");
        sb.append(winners.calculateYield(totalSpent)).append("\n");
    }

    private String winnerResult(Winners winners) {
        StringBuilder sb = new StringBuilder();

        for (Rank rank : Rank.values()) {
            appendResultMessages(winners, sb, rank);
        }

        return sb.toString();
    }

    private void appendResultMessages(Winners winners, StringBuilder sb, Rank rank) {
        sb.append(rank.getMatchCount()).append("개 일치, ");

        if (rank.isDependsBonus()) {
            sb.append("보너스볼 일치, ");
        }

        sb.append(rank.getPrize()).append("원 - ")
          .append(winners.getResult().getOrDefault(rank, 0L)).append("개 당첨\n");
    }

    private void resolveStartMessages(Lottos lottos, StringBuilder sb) {
        lottos.getLottos().forEach(lotto -> sb.append(lotto.toString()));
    }
}
