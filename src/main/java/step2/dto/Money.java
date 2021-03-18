package step2.dto;

public class Money {
    private final int amount;

    public Money(int amount){
        if(amount<0) throw new IllegalArgumentException();
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
