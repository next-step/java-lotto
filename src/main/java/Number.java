import java.util.Objects;

public class Number {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public static Number valueOf(String number) {
        try {
            validateNullOrEmpty(number);
            return new Number(Integer.parseInt(number));
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("잘못된 숫자 형식 입니다.");
        }
    }

    private static void validateNullOrEmpty(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new IllegalArgumentException("숫자는 빈 값일 수 없습니다.");
        }
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

    public Number plus(Number value) {
        return new Number(number + value.number);
    }

    public Number subtract(Number value) {
        return new Number(number - value.number);
    }

    public Number multiply(Number value) {
        return new Number(number * value.number);
    }

    public Number divide(Number value) {
        if (value.number == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        if (number % value.number != 0) {
            throw new ArithmeticException("나눗셈 결과가 정수로 나누어 떨어지지 않습니다.");
        }

        return new Number(number / value.number);
    }
}
