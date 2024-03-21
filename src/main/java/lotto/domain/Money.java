package lotto.domain;

public class Money {

    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public void spend(int amount) {
        if (this.amount < amount) {
            throw new IllegalArgumentException("돈이 부족합니다");
        }
        this.amount -= amount;
    }

    public int maxPurchasableQuantity(int price) {
        return this.amount / price;
    }
}
