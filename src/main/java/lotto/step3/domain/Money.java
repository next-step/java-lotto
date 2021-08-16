package lotto.step3.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    int money;
    public Money(int money) {
        if (money< LOTTO_PRICE){
            throw new IllegalArgumentException("돈이 부족합니다.로또 1장의 가격은 "+LOTTO_PRICE+"원 입니다.");
        }
        this.money = money;
    }
}
