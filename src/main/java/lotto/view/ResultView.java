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

        for (Map.Entry<Rank, Long> entry : matchResult.entrySet()) {
            System.out.println(entry.getKey().getMatchCount() + "개 일치 (" + entry.getKey().getPrizeMoney() + ")- " + matchResult.getOrDefault(entry.getKey(), 0L) + "개");
        }

        System.out.println("총 수익률은 " + lottoResult.getReturnRate(purchasePrice) + "입니다.");
    }
}
