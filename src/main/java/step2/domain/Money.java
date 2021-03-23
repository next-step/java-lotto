package step2.domain;

public class Money {
    private final int amount;

    public Money(int amount) {
        if(!valid(amount)) throw new IllegalArgumentException();
        this.amount = amount;
    }

    public final int getAmount() {
        return amount;
    }

    private boolean valid(int amount){
        return amount>=0;
    }

}
