package step2.model;

import step2.exception.NotEnoughMoneyException;

import java.util.Objects;

public class Money {

    private final int totalAmount;
    private int usedAmount;

    private Money(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static Money valueOf(int totalAmount) {
        return new Money(totalAmount);
    }

    public void useAmount(Priceable priceable) {
        validateUseAmount(priceable);
        this.usedAmount += priceable.getPrice();
    }

    public boolean isAvailableAmount(Priceable priceable) {
        return (this.usedAmount + priceable.getPrice()) <= this.totalAmount;
    }

    public int getRemainingAmount() {
        return totalAmount - usedAmount;
    }

    public int getUsedAmount() {
        return this.usedAmount;
    }

    private void validateUseAmount(Priceable priceable) {
        if (!this.isAvailableAmount(priceable)) {
            throw new NotEnoughMoneyException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return getRemainingAmount() == money.getRemainingAmount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getRemainingAmount());
    }
}
