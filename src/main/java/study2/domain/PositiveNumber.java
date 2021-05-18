package study2.domain;

public class PositiveNumber {

    private final int number;

    private PositiveNumber(int number) {
        this.number = number;
    }

    public static PositiveNumber of(String number) {
        return new PositiveNumber(Integer.parseInt(number));
    }

    public static PositiveNumber of(int number) {
        return new PositiveNumber(number);

    }
}
