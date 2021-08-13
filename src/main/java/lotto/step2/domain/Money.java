package lotto.step2.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("돈이 부족합니다. 로또 1장의 가격은 "+LOTTO_PRICE+"원입니다.");
        }

    }
}
