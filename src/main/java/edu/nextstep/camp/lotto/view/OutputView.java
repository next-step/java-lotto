package edu.nextstep.camp.lotto.view;

import java.util.List;
import java.util.Map;

import edu.nextstep.camp.lotto.domain.Prize;
import edu.nextstep.camp.lotto.domain.Rank;

public class OutputView {
    private OutputView() {}

    public static void printPurchasedLotto(List<List<String>> purchaseList) {
        System.out.printf("%d장을 구입했습니다.\n", purchaseList.size());

        for (List<String> lotto : purchaseList) {
            System.out.println("[" + String.join(",", lotto) + "]");
        }
    }

    public static void printGameResult(Map<Rank, Long> ranks, long totalPrize, float earningRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + Prize.FOURTH_PRIZE + "원)-" + ranks.get(Rank.FOURTH));
        System.out.println("4개 일치 (" + Prize.THIRD_PRIZE + "원)-" + ranks.get(Rank.THIRD));
        System.out.println("5개 일치 (" + Prize.SECOND_PRIZE + "원)-" + ranks.get(Rank.SECOND));
        System.out.println("6개 일치 (" + Prize.FIRST_PRIZE + "원)-" + ranks.get(Rank.FIRST));
        System.out.println("총 상금: " + totalPrize);
        System.out.println("총 수익률은 " + earningRate + "입니다.");
    }
}
