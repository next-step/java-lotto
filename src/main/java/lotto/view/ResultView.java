package lotto.view;

import lotto.domain.*;

public class ResultView {

    public static void showBuyLottos(LottoGroup lottoGroup, LottoPurChase lottoPurchase) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", lottoPurchase.getManualCount(), lottoPurchase.getAutoCount());

        for (Lotto lotto : lottoGroup.getLottoNumbers()) {
            System.out.println(lotto);
        }
    }

    public static void showStatus(LottoResult lottoResult, Money money) {
        System.out.println("당첨 통계");
        System.out.println("-------");

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank == LottoRank.MISS) continue;

            int count = lottoResult.getCntByLottoRank(lottoRank);
            System.out.println(lottoRank.getMessage(count));
        }

        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",
                money.getYield(lottoResult.calTotal()));
    }
}
