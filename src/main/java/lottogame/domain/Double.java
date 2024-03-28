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
        return from(value * from.getValue());
    }

    public double multiply(int from) {
        return value * from;
    }

    public Double add(Number from) {
        return from(value + from.getValue());
    }

    public Double divide(Double from) {
        return from(value / from.value);
    }

    public int convertToInt() {
        return (int) value;
    }

    public double formattingTwoDecimal() {
        return Math.floor(value * 100) / 100;
    }
}
