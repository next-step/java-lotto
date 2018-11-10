package game.lotto.model;

public class Amount {

    private int value;

    public Amount(Money money) {
        this.value = computeAmount(money);
    }

    public Amount(Amount amount) {
        this.value = amount.value;
    }

    private int computeAmount(Money money) {
        return money.getValue() / Money.LOTTO_PRICE;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
