package lotto.domain;

import java.util.List;

public class LottoShop {

    private static final int LOTTO_PRICE = 1_000;

    private LottoShop() {

    }

    public static LottoSet buy(int money) {
        return LottoSet.create(money / LOTTO_PRICE);
    }

    public static LottoSet buy(LottoWallet lottoWallet) {
        int numberOfBuy = lottoWallet.numberOfBuy(LOTTO_PRICE);
        List<Lotto> lottos = lottoWallet.getManualLottos();
        return LottoSet.create(numberOfBuy, lottos);
    }
}
