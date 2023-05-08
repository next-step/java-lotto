package lottoauto.view;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lottoauto.model.LottoResult;
import lottoauto.model.Lottos;
import lottoauto.model.WinningReward;

public class ResultView {

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
        lottos.getLottos().forEach(System.out::println);
    }

    public void printStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (Integer integer : lottoResult.getMatchCount()) {
            WinningReward rewardByMatches = WinningReward.findRewardByMatches(integer);
            System.out.printf("%d개 일치 (%d원) - %d개\n", integer, rewardByMatches.getReward(),
                    Collections.frequency(lottoResult.getMatchCount(), integer));
        }


    }

    public void printRate(double rate) {
        System.out.printf("총 수익률은 %f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임.)", rate);
    }
}
