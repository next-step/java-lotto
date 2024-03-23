package lottogame.domain;

import java.util.List;

public class LottoGame {
    private static final int PRICE = 1_000;

    public double calculateReturnOfRate(Lotto winnerLotto, List<Lotto> lottos) {
        int returnOfRate = 0;
        int purchaseAmount = calculatePurchaseAmount(lottos);
        for (Lotto lotto : lottos) {
            returnOfRate += winnerLotto.getPrize(lotto);
        }
        return Math.floor(((double) returnOfRate / purchaseAmount) * 100) / 100;
    }

    private int calculatePurchaseAmount(List<Lotto> lottos) {
        return lottos.size() * PRICE;
    }
}
