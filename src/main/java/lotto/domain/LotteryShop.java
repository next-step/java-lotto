package lotto.domain;

import lotto.domain.lotto.AutoLottoGenerator;
import lotto.domain.lotto.Lottos;

public class LotteryShop {
    public static final long LOTTO_PRICE = 1000L;

    private LotteryShop() {}

    public static Lottos purchase(Cash cash) {
        return AutoLottoGenerator.tickets(cash.buyableAmount(LOTTO_PRICE));
    }

}
