package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class OutputView {
    private static final int FIRST_PRIZE = 6;
    private static final int SECOND_PRIZE = 5;
    private static final int THIRD_PRIZE = 4;
    private static final int FOURTH_PRIZE = 3;

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printStatics(Map<Integer, Integer> ranks, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (5000원) : " + ranks.getOrDefault(FOURTH_PRIZE, 0) + "개");
        System.out.println("4개 일치 (50000원) : " + ranks.getOrDefault(THIRD_PRIZE, 0) + "개");
        System.out.println("5개 일치 (1500000원) : " + ranks.getOrDefault(SECOND_PRIZE, 0) + "개");
        System.out.println("6개 일치 (2000000000원) : " + ranks.getOrDefault(FIRST_PRIZE, 0) + "개");
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }

}
