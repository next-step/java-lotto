package step3.view;

import step3.domain.Lotto;
import step3.domain.Lottos;
import step3.domain.LottoResult;
import step3.domain.Rank;

import java.util.List;

public class ResultView {

    public static void printLottoList(Lottos lottoList) {
        List<Lotto> lottos = lottoList.getLottos();

        System.out.println(lottos.size() + "개를 구매했습니다");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.sortedNumbers());
        }
    }

    public static void printLottoResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : Rank.values()) {
            printRankResult(rank, result);
        }
        System.out.println("총 수익률은 " + result.getProfitRatio() + "입니다.");
    }

    private static void printRankResult(Rank rank, LottoResult result) {
        if (rank == Rank.MISS) {
            return;
        }
        System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getWinningMoney() + "원) - " + result.getRankCount(rank) + "개");
    }

}
