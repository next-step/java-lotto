package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printStatics(Map<LottoPrize, Integer> ranks, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (5000원) : " + ranks.getOrDefault(LottoPrize.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50000원) : " + ranks.getOrDefault(LottoPrize.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1500000원) : " + ranks.getOrDefault(LottoPrize.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원) : " + ranks.getOrDefault(LottoPrize.SECOND, 0) + "개");
        System.out.println("6개 일치 (2000000000원) : " + ranks.getOrDefault(LottoPrize.FIRST, 0) + "개");
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }

}
