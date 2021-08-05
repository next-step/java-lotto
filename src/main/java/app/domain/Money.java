package app.domain;

import app.action.LottoMarket;

public class Money {
    private int money;

    private Money(int money) {
        validation(money);
        this.money = money;
    }

    public static Money of(int money){
        return new Money(money);
    }

    private void validation(int money) {
        if(money < 0){
            throw new IllegalArgumentException("객체 생성 Error "+money);
        }
    }

    public int getMoney() {
        return money;
    }
}
