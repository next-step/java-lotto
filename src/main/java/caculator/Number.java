package caculator;

public class Number {

    private int value;

    public Number(String value) {
        this.value = Integer.parseInt(value);
    }
    public Number(int value) {
        this.value = value;
    }

    public Number plus(Number other) {
        return new Number(this.value += other.value);
    }

    public Number minus(Number other) {
        return new Number(this.value -= other.value);
    }

    public Number multiple(Number other) {
        return new Number(this.value *= other.value);
    }

    public Number divide(Number other) {
        return new Number(this.value /= other.value);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Number number = (Number) obj;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

}

