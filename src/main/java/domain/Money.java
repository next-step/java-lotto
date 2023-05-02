package domain;

public class Money extends Number{
    public Money(String value) {
        super(value);
        if (!isValidMoney(this.value())) {
            throw new IllegalArgumentException("Invalid money: " + value);
        }
    }

    private boolean isValidMoney(int value) {
        return 0 <= value && value <= 100000;
    }
}
