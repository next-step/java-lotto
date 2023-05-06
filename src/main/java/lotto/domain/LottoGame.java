package lotto.domain;

import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    public static long lottoCount(long price) {
        return price / LOTTO_PRICE;
    }

    public static LottoRewards reward(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoRewards lottoRewards = new LottoRewards();

        for (Lotto lotto : lottos) {
            lotto.increaseLottoRewardCount(lottoRewards, winningLotto);
        }

        return lottoRewards;
    }

    public static double totalProfitRate(LottoRewards lottoRewards, long purchasePrice) {
        return (double) lottoRewards.totalProfit() / purchasePrice;
    }
}
