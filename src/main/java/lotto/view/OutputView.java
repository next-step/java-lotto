package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rewards;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void showPurchasedLotto(List<Lotto> lottoSession) {
        System.out.println(lottoSession.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoSession) {
            System.out.println(Arrays.toString(lotto.getLotto()));
        }
        System.out.println();
    }

    // TODO: 당첨 갯수, 상금 -> enum
    public static void showResult(Map<Integer, Integer> result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-----------");

        for (int i = LottoGame.MINIMUM_REWARD_MATCH; i <= LottoGame.MAXIMUM_REWARD_MATCH; i++) {
            System.out.println(i + "개 일치 (" +
                    Rewards.getRewards(i).getPrize() + "원)- " +
                    result.get(i) + "개");
        }
    }

    public static void showROR(Map<Integer, Integer> result, int purchaseAmount) {
        System.out.println("총 수익률은 " + (double) Rewards.getWholePrize(result) / purchaseAmount + "입니다.");
    }
}
