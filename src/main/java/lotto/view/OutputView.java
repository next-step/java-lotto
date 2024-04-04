package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void showPurchasedLotto(List<Lotto> lottoSession) {
        System.out.println(lottoSession.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoSession) {
            System.out.println(Arrays.toString(lotto.getLotto().toArray()));
        }
        System.out.println();
    }

    // TODO: 당첨 갯수, 상금 -> enum
    public static void showResult(Map<LottoRank, Long> result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-----------");

        StringBuilder stringBuilder = new StringBuilder();


        for (int i = LottoGame.MINIMUM_REWARD_MATCH; i <= LottoGame.MAXIMUM_REWARD_MATCH; i++) {
            stringBuilder
                    .append(i).append("개 일치 (")
                    .append(LottoRank.getLottoRank(i).getPrize()).append("원)- ")
                    .append(result.get(LottoRank.getLottoRank(i)) != null ? result.get(LottoRank.getLottoRank(i)) : 0).append("개")
                    .append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void showROR(Map<LottoRank, Long> result, int purchaseAmount) {
        System.out.println("총 수익률은 " + (double) LottoRank.getWholePrize(result) / purchaseAmount + "입니다.");
    }
}
