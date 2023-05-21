package domain;

public class Money extends Number{
    public Money(String value) {
        super(value);
        if (!isValidMoney(this.value())) {
            throw new IllegalArgumentException("Invalid money: " + value);
        }
    }

    public Money(int value) {
        super(value);
        if (!isValidMoney(this.value())) {
            throw new IllegalArgumentException("Invalid money: " + value);
        }
    }

    public Money add(Money money) {
        return new Money(String.valueOf(this.value() + money.value()));
    }

    public Money subtract(Money money) {
        return new Money(String.valueOf(this.value() - money.value()));
    }

    private boolean isValidMoney(int value) {
        return 0 <= value && value <= 100000;
    }

    @Override
    public String toString() {
        return String.valueOf(value());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            return value() == ((Money) obj).value();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value();
    }
}
