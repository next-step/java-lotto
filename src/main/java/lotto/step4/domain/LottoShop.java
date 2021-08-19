package lotto.step4.domain;

public class LottoShop {
    public Lotteries receiveMoney(int money) {
        new Money(money);
        return new Lotteries(money / Money.LOTTO_PRICE);
    }
}
