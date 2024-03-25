package lotto.domain;

import lotto.domain.lotto.AutoLottoGenerator;
import lotto.domain.lotto.Lottos;

public class LotteryShop {
    public static final Cash LOTTO_PRICE = new Cash(1000L);

    private LotteryShop() {}

    public static Lottos purchaseAuto(Cash cash) {
        return AutoLottoGenerator.tickets(cash.buyableAmount(LOTTO_PRICE));
    }

}
