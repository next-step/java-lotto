package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.enums.MatchNumberAndPrize;

import java.util.List;
import java.util.Map;

public class LottoResultView {
    private LottoResultView () {

    }

    public static void printLottoCount(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void printLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoStatistical(Map<MatchNumberAndPrize, Integer> winningAmountIntegerMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (MatchNumberAndPrize matchNumberAndPrize : MatchNumberAndPrize.values()) {
            if (matchNumberAndPrize == MatchNumberAndPrize.NON) continue;
            System.out.printf("%d개 일치 (%d원)- %d개\n",
                    matchNumberAndPrize.getMatchNumber(),
                    matchNumberAndPrize.getPrize(),
                    winningAmountIntegerMap.get(matchNumberAndPrize));
        }
    }

    public static void printYield(float yield) {
        System.out.printf("총 수익률은 %.2f 입니다.", yield);
        if (yield < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
