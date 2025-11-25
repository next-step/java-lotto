package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void showBuyLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void showStatus(Map<LottoRank, Integer> map, int money) {
        System.out.println("당첨 통계");
        System.out.println("-------");

        for (LottoRank lottoRank : LottoRank.values()) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", lottoRank.getMatchCnt(), lottoRank.getPrizeMoney(), map.get(lottoRank));
        }

        double sum = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            sum += map.get(lottoRank) * lottoRank.getPrizeMoney();
        }

        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", sum / (double) money);
    }
}
