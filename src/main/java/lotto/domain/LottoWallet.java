package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoWallet {
    private static final int DECIMAL_PLACES = 2;

    private int money;

    private LottoWallet(int money) {
        this.money = money;
    }

    public static LottoWallet create(int money) {
        return new LottoWallet(money);
    }

    public int numberOfBuy(int price) {
        return money / price;
    }

    public BigDecimal rateReturn(int reward) {
        BigDecimal amountMoney = BigDecimal.valueOf(money);
        BigDecimal rewardMoney = BigDecimal.valueOf(reward);

        return rewardMoney.divide(amountMoney, DECIMAL_PLACES, RoundingMode.DOWN);
    }
}
