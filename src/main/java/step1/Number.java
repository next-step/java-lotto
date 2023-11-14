package step1;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(String number) {
        this.number = parseStringToNumber(number);
    }

    public Number(int number) {
        this.number = number;
    }

    private int parseStringToNumber(String input) {

        int number = 0;
        try{
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }

        return number;
    }

    public Number plus(Number number) {

        return new Number(this.number + number.number);
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
