package lotto.step3.domain;

public class LottoShop {
    private static final int LOTTO_PRICE = 1000;

    public Lotteries receiveMoney(int money) {
        new Money(money);

        return new Lotteries(money / LOTTO_PRICE);
    }
}
