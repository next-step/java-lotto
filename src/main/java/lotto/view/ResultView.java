package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class ResultView {

    public static void showBuyLottos(LottoGroup lottoGroup) {
        System.out.printf("%d개를 구매했습니다.%n", lottoGroup.getLottoNumbers().size());

        for (Lotto lotto : lottoGroup.getLottoNumbers()) {
            System.out.println(lotto);
        }
    }

    public static void showStatus(LottoResult lottoResult, int money) {
        System.out.println("당첨 통계");
        System.out.println("-------");

        for (LottoRank lottoRank : LottoRank.values()) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", lottoRank.getMatchCnt(), lottoRank.getPrizeMoney(), lottoResult.getCntByLottoRank(lottoRank));
        }

        int total = lottoResult.calTotal();

        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", (double) total / (double) money);
    }
}
