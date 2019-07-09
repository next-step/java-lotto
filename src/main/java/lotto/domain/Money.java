package lotto.domain;

/**
 * Created by wyparks2@gmail.com on 2019-07-08
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Money {
    private static final int LOTTO_PRICE = 1_000;

    private int money;

    public Money(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException();
        }

        this.money = money;
    }

    public int canBuyLottoCount() {
        return money / LOTTO_PRICE;
    }
}
