package lotto.domain;

import lotto.domain.lotto.AutoLottoGenerator;
import lotto.domain.lotto.Lottos;

public class LotteryShop {
    public static final Cash LOTTO_PRICE = new Cash(1000L);

    private LotteryShop() {}

    public static Cash purchaseManualAndChange(Cash cash, Amount amount) {
        final Cash totalPrice = LOTTO_PRICE.multiply(amount);
        if (cash.smallerThan(totalPrice)) {
            throw new IllegalArgumentException("현금이 부족합니다.");
        }

        return cash.subtract(totalPrice);
    }

    public static Lottos purchaseAuto(Cash cash) {
        return AutoLottoGenerator.tickets(cash.buyableAmount(LOTTO_PRICE));
    }

}
