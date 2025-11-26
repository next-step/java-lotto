package lotto.view;

import lotto.domain.*;

public class ResultView {

    public static void showBuyLottos(LottoGroup lottoGroup) {
        System.out.printf("%d개를 구매했습니다.%n", lottoGroup.getLottoNumbers().size());

        for (Lotto lotto : lottoGroup.getLottoNumbers()) {
            System.out.println(lotto);
        }
    }

    public static void showStatus(LottoResult lottoResult, Money money) {
        System.out.println("당첨 통계");
        System.out.println("-------");

        for (LottoRank lottoRank : LottoRank.values()) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", lottoRank.getMatchCnt(), lottoRank.getPrizeMoney(), lottoResult.getCntByLottoRank(lottoRank));
        }

        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", money.getYield(lottoResult.calTotal()));
    }
}
