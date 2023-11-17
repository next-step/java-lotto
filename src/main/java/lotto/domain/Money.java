package lotto.domain;

public class Money {

    private final long money;

    public Money(long money) {
        this.money = money;
    }
    public Money plus(long addMoney){
        return new Money(this.money+addMoney);
    }

    public long find(){
        return this.money;
    }
}
