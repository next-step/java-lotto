package lottogame.domain;

public class Money {

    private Double value;

    public Money(Double value) {
        this.value = value;
    }

    public static Money from(double value) {
        return new Money(Double.from(value));
    }

    public static Money from(Double value) {
        return new Money(value);
    }

    public Money multiply(Number from) {
        return from(value.multiply(from));
    }

    public Money add(Number prize) {
        return from(value.add(prize));
    }

    public Money divide(Money from) {
        return from(value.divide(from.value));
    }

    public int toInt() {
        return value.toInt();
    }

    public double toTwoDecimal() {
        return value.toTwoDecimal();
    }
}
