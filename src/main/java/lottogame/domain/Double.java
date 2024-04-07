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

    public boolean isMoreThen(Double other) {
        return this.value > other.value;
    }

    public boolean isLessThan(Double other) {
        return value < other.value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Double aDouble = (Double) object;

        return java.lang.Double.compare(value, aDouble.value) == 0;
    }

    @Override
    public int hashCode() {
        long temp = java.lang.Double.doubleToLongBits(value);
        return (int) (temp ^ (temp >>> 32));
    }
}
