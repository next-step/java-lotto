package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Match;

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
        Map<Match, Integer> matchResult = lottoResult.getMatchResult();

        for (Map.Entry<Match, Integer> entry : matchResult.entrySet()) {
            System.out.println(entry.getKey().getMatchCount() + "개 일치 (" + entry.getKey().getPrizeMoney() + ")- " + matchResult.getOrDefault(entry.getKey(), 0) + "개");
        }

        System.out.println("총 수익률은 " + lottoResult.getReturnRate(purchasePrice) + "입니다.");
    }
}
