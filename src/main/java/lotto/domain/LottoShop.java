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
        List<Lotto> lottos = lottoWallet.getManualLottos();
        Money money = lottoWallet.getMoney();

        int numberOfBuy = numberOfBuy(money, lottos.size());
        return LottoSet.create(numberOfBuy, lottos);
    }

    public static int numberOfBuy(Money money, int numberOfManualLottos) {
        return money.numberOfBuy(LOTTO_PRICE) - numberOfManualLottos;
    }
}
