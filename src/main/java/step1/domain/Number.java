package step1.domain;

public class Number {
    private final int number;

    private Number(final int number) {
        if (number < 0) {
            throw new RuntimeException("Negative numbers are not possible");
        }
        this.number = number;
    }

    public static Number from(final int number) {
        return new Number(number);
    }

    public int getNumber() {
        return number;
    }
}
