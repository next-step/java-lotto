package lotto.domain;

public class Positive {
    private final int number;

    public Positive(String s) {
        this(Integer.parseInt(s));
    }

    public Positive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수 값이 들어올 수 없습니다.");
        }
        this.number = number;
    }

    public int get() {
        return number;
    }

    public Positive plus(int number) {
        return new Positive(this.number + number);
    }

    public Positive plus(Positive number) {
        return new Positive(this.number + number.number);
    }

    public Positive minus(int number) {
        return new Positive(this.number - number);
    }

    public Positive minus(Positive number) {
        return new Positive(this.number - number.number);
    }

    public Positive divide(int number) {
        return new Positive(this.number / number);
    }

    public Positive divide(Positive number) {
        return new Positive(this.number / number.number);
    }

    public boolean smallerThan(Positive number) {
        return this.number < number.number;
    }

    @Override
    public boolean equals(Object o) {
        assert o instanceof Positive;
        return number == ((Positive) o).number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }
}
