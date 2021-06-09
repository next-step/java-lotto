package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public class ResultView {

    public void resultBuyPrice(int buyCount) {
        System.out.println(buyCount + "개를 구매했습니다.");
    }

    public void resultLottoList(LottoList lottoList) {
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void resultStatistics(WinningStatistics winning) {

        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue;
            }
            if (winning.getStatistics().get(rank) != null) {
                System.out.println(rank.getMessage() + "(" + rank.getMoney() + "원) - " + winning.getStatistics().get(rank) + "개");
            } else {
                System.out.println(rank.getMessage() + "(" + rank.getMoney() + "원) - " + 0 + "개");
            }

        }

        System.out.println("총 수익률 은 " + winning.yield() + "입니다");

    }
}
