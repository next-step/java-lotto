package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.common.LottoPrizeMoney;
import lotto.domain.lotto.Lotto;

public class ResultView {

    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        purchasedLottos.forEach(lotto -> System.out.println(lotto.getValues()));
    }

    public static void printWinningStatistics(Map<Integer, Integer> matchLottoCounts) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        matchLottoCounts.keySet().forEach(
            key -> System.out.printf("%d개 일치 (%d원)- %d개%n", key, LottoPrizeMoney.findByMatchNumberCount(key), matchLottoCounts.get(key)));
    }

    public static void printEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + earningRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임");
    }
}
