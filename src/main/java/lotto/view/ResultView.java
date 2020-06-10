package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printLottos(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printStatistics(LottoResult lottoResult, int purchasePrice){
        System.out.println("당첨통계");
        System.out.println("---------");
        Map<Rank, Long> matchResult = lottoResult.getMatches();

        for (Rank rank : Rank.successValues()) {
            System.out.println(rank.getMatchCount() + "개 일치" + secondPrizeCheck(rank) + "(" + rank.getPrizeMoney() + ")- " + matchResult.getOrDefault(rank, 0L) + "개");
        }

        System.out.println("총 수익률은 " + lottoResult.getReturnRate(purchasePrice) + "입니다.");
    }

    private String secondPrizeCheck(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return ", 보너스볼 일치";
        }
        return "";
    }
}
