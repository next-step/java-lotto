package lotto.view;

import lotto.domain.*;

public class ResultView {

    public void printAllLotto(Lottos lottos, Tickets tickets) {
        int manualCount = tickets.getManualCount();
        int autoCount = tickets.getAutoCount();

        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "장이 생성 됐습니다");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
    }

    public void printLottoResult(Lottos lottos) {
        LottoResult result = lottos.getLottoResult();
        for (Rank rank : Rank.values()) {
            printMatch(result, rank);
        }
        System.out.println("총 수익률은 " + result.getPrizeRate() + "입니다.");
    }

    private void printMatch(LottoResult result, Rank rank) {
        if (rank.getMatch() == 7) {
            System.out.println(rank.getRank() + "개 일치, 보너스 볼 일치 (" + rank.getPrize() + ") - " + result.getResultByRank(rank) + "개");
            return;
        }
        System.out.println(rank.getRank() + "개 일치 (" + rank.getPrize() + ") - " + result.getResultByRank(rank) + "개");
    }
}
