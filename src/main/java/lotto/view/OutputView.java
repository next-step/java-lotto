package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Profit;
import lotto.domain.Rank;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printStatics(Map<Rank, Integer> ranks, Profit profitRate) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (" + Rank.FIFTH.getPrize() + "원) : " + ranks.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (" + Rank.FOURTH.getPrize() + "원) : " + ranks.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (" + Rank.THIRD.getPrize() + "원) : " + ranks.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (" + Rank.SECOND.getPrize() + "원) : " + ranks.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (" + Rank.FIRST.getPrize() + "원) : " + ranks.getOrDefault(Rank.FIRST, 0) + "개");
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }

}
