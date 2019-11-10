package lotto.view;

import lotto.data.Rank;
import lotto.data.Winners;

public class LottoResult {
    private final Winners winners;
    private final long totalSpent;

    public LottoResult(Winners winners, long totalSpent) {
        this.winners = winners;
        this.totalSpent = totalSpent;
    }

    public String viewResult() {
        StringBuilder sb = new StringBuilder();

        sb.append("결과 확인: \n");
        sb.append(winnerResult(winners)).append("\n");
        sb.append("총 수익률: \n");
        sb.append(winners.calculateYield(totalSpent)).append("\n");

        return sb.toString();
    }

    private String winnerResult(Winners winners) {
        StringBuilder sb = new StringBuilder();

        for (Rank rank : Rank.values()) {
            getResultMessages(winners, sb, rank);
        }

        return sb.toString();
    }

    private void getResultMessages(Winners winners, StringBuilder sb, Rank rank) {
        sb.append(rank.getMatchCount()).append("개 일치, ");

        if (rank.isDependsBonus()) {
            sb.append("보너스볼 일치, ");
        }

        sb.append(rank.getPrize()).append("원 - ")
          .append(winners.getResult().getOrDefault(rank, 0L)).append("개 당첨\n");
    }
}
