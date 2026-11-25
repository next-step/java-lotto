package domain;

public class Purchase {

    private final int value;

    public Purchase(int value) {
        validate(value);
        this.value = value;
    }


    private static void validate(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 한다.");
        }
    }

    public int divideBy(int divisor) {
        return value / divisor;
    }
}
