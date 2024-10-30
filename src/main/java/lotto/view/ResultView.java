package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoPrize;

import java.util.Map;


public class ResultView {
    private static final int MIN_MATCH_COUNT = 3; // 최소 일치 개수
    private static final int MAX_MATCH_COUNT = 6; // 최대 일치 개수
    public static void printLottos(LottoManager lottoManager) {

        System.out.printf("%d개를 구매했습니다.", lottoManager.countPurchasedLottos());
        System.out.println();

        for (Lotto lotto : lottoManager.purchasedLottos()) {
            System.out.println(lotto);
        }
    }

    public static void printResults(Map<Integer, Integer> results) {

        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int matchCount = MIN_MATCH_COUNT; matchCount <= MAX_MATCH_COUNT; matchCount++) {
            int count = results.get(matchCount);

            int prizeAmount = LottoPrize.getWinningAmount(matchCount);

            System.out.printf("%d개 일치 (%d원) - %d개%n", matchCount, prizeAmount, count);
        }

    }
}
