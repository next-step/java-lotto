import java.util.Objects;

public class Number {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String numStr) {
        this.number = Integer.parseInt(numStr);

        if (isNegative(number))
            throw new RuntimeException("숫자가 음수입니다.");
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

    public static Number sum(Number number1, Number number2) {
        return new Number(number1.number + number2.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
