package lottogame.domain;

public final class Double {
    private final double value;

    private Double(double value) {
        this.value = value;
    }

    public static Double from(double value) {
        return new Double(value);
    }

    public Double multiply(Number from) {
        return from(value * from.intValue());
    }

    public Double add(Number from) {
        return from(value + from.intValue());
    }

    public Double divide(Double from) {
        return from(value / from.value);
    }

    public int toInt() {
        return (int) value;
    }

    public double toTwoDecimal() {
        return Math.floor(value * 100) / 100;
    }
}
