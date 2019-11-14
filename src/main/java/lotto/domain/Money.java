package lotto.domain;

public class Money {
    private static final int LOTTO_AMOUNT = 1000;
    private final int amount;
    private int count;
    private int balance;

    public Money(int amount) {
        this.amount = amount;
        this.count = amount / LOTTO_AMOUNT;
        this.balance = amount;
    }

    public int getBalance() {
        return balance;
    }

    public int purchased(int purchasedCount) {
        this.count = count - purchasedCount;
        this.balance = balance - (purchasedCount * LOTTO_AMOUNT);
        return count;
    }

    public int purchaseCount() {
        return this.balance / LOTTO_AMOUNT;
    }
}
