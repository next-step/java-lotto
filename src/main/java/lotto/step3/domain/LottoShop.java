package lotto.step3.domain;

import java.util.List;

public class LottoShop {
    public Lotteries receiveMoney(int money) {
        new Money(money);
        return new Lotteries(money / Money.LOTTO_PRICE);
    }
}
