package lotto.model;

import lotto.factory.LottoFactory;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private LottoStore() {
    }

    public static Lotto ticket(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        return LottoFactory.autoCreateLotto(count);
    }

    public static void match(Lotto lotto, LottoWinner winner) {
        for (LottoNumbers lottoNumbers : lotto.getLotto()) {
            winner.match(lottoNumbers);
        }
    }

}
