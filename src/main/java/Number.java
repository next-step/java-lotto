import java.util.Objects;

public class Number {
    private static final int ZERO = 0;

    private final int number;

    public Number(String number) {
        this(Integer.valueOf(number));
    }

    public Number(int number) {
        this.number = number;
        if (this.number < ZERO) {
            throw new NumberFormatException("음수를 사용할 수 없습니다.");
        }
    }

    public Number add(Number number) {
        return new Number(this.number + number.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
