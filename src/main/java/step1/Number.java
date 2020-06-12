package step1;

import java.util.Objects;

public final class Number {

    private final int number;

    public Number(String text) {
        check(text);
        this.number = Integer.parseInt(text);
    }

    public int plus(Number number) {
        return this.number + number.number;
    }

    private void check(String text) {
        checkEmpty(text);
        checkNull(text);
        checkNotNegative(text);
    }

    private void checkEmpty(String text) {
        if(text.isEmpty()) {
            throw new RuntimeException(Error.INVALID_NUMBER);
        }
    }

    private void checkNotNegative(String text) {
        if(Integer.parseInt(text) < 0) {
            throw new RuntimeException(Error.NOT_NEGATIVE_NUMBER);
        }
    }

    private void checkNull(String text) {
        if(text == null) {
            throw new RuntimeException(Error.INVALID_NUMBER);
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


    public static Number of(int number) {
        return new Number(number);
    }

    private Number(int number) {
        this.number = number;
    }

    public Number sum(Number number) {
        return Number.of(this.number + number.number);
    }

    public int valueOf() {
        return this.number;
    }


}
