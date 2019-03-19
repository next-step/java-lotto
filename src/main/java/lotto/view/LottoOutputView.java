package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.LottoProfit;
import lotto.dto.LottoStatistics;

import java.util.List;

public class LottoOutputView {

    public static void showBuyCount(LottoProfit lottoProfit) {
        System.out.println("\n수동으로 " + lottoProfit.getBuyDirectCount() + "장, 자동으로 " + lottoProfit.getBuyAutoCount() + "개를 구매했습니다.");
    }

    /**
     * 구매한 로또 view
     */
    public static void showBuyLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    /**
     * 당첨 통계 view
     */
    public static void showWinningStatistics(LottoStatistics lottoStatistics) {
        System.out.println("\n당첨 통계\n---------");

        System.out.println("3개 일치 (5000원)- " + lottoStatistics.getLottoMatchCount().getFifthCnt() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoStatistics.getLottoMatchCount().getForthCnt() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoStatistics.getLottoMatchCount().getThirdCnt() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + lottoStatistics.getLottoMatchCount().getSecondCnt() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoStatistics.getLottoMatchCount().getFirstCnt() + "개");
        System.out.println("총 수익률은 "
                + lottoStatistics.getLottoProfit().getProfit()
                + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
