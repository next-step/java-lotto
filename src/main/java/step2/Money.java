package step2;

public class Money {
    private int value;

    private Money(final int money) {
        this.value = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }
    
    public int divide(final Money money) {
        return value / money.value;
    }
}
