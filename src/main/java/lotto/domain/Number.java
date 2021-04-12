package lotto.domain;


import java.util.Objects;

public class Number implements Comparable<Number> {
    private int number = 0;
    private final int one = 1;
    private final int fortyFive = 45;

    public Number(final int number) {
        exceedCheckNumber(number);
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    @Override
    public int compareTo(Number o) {
        Integer a = this.number;
        Integer b = o.number;
        return a.compareTo(b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private void exceedCheckNumber(int number) {
        if (one > number || number > fortyFive) {
            throw new IllegalArgumentException("입력할수 있는 숫자범위를 넘었습니다.(1~45)");
        }
    }
}
