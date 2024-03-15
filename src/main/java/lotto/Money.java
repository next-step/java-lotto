package lotto;

public class Money {

    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

    public void spend(int amount) {
        this.amount -= amount;
    }
}
