package lottoauto.view;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lottoauto.model.Lottos;
import lottoauto.model.WinningReward;

public class ResultView {

    public void printBuyLottoQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
    }

    public void printStatistics(Map<Integer, AtomicInteger> lottoStatisticsMap, double revenueRate) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (int i = 3; i < 7; i++) {
            WinningReward rewardByMatches = WinningReward.findRewardByMatches(i);
            System.out.printf("%d개 일치 (%d원) - %d개\n", rewardByMatches.getMatch(), rewardByMatches.getReward(),
                    lottoStatisticsMap.getOrDefault(i, new AtomicInteger()).get());
        }
//        System.out.printf("3개 일치 (5000원) - %d개\n");
//        System.out.printf("4개 일치 (50000원) - %d개\n");
//        System.out.printf("5개 일치 (1500000원) - %d개\n");
//        System.out.printf("6개 일치 (2000000000원) - %d개\n");
        System.out.printf("총 수익률은 %f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임.)", revenueRate);
    }
}
