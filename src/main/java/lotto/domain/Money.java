package lotto.domain;

public class Money {
    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public boolean checkPayAble(int price) {
        return value >= price;
    }

    public Money pay(int price) {
        return new Money(value - price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}
