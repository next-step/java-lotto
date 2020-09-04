package cc.oakk.lotto.model;

import java.util.Objects;

public class Money {
    private int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액이 0원보다 작습니다.");
        }
        this.money = money;
    }
    
    public int get() {
		return money;
	}

    public Money purchase(int price) {
        if (money < price) {
            throw new IllegalArgumentException("잔고가 부족합니다.");
        }
        money -= price;
        return this;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return this.money == money.money;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(money);
    }	
}
