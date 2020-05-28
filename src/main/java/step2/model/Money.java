package step2.model;

import step2.exception.NotEnoughMoneyException;

import java.util.Objects;

public class Money {

    private int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money valueOf(int amount) {
        return new Money(amount);
    }

    public void useAmount(Priceable priceable) {
        validateUseAmount(priceable);
        this.amount -= priceable.getPrice();
    }

    private void validateUseAmount(Priceable priceable) {
        if (!this.isAvailableAmount(priceable)) {
            throw new NotEnoughMoneyException();
        }
    }

    public boolean isAvailableAmount(Priceable priceable) {
        return priceable.getPrice() <= this.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
