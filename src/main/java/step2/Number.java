package step2;

import java.util.Objects;
import java.util.Random;

public final class Number {

    private static final Random random = new Random();
    private final int number;

    public static Number random(){
        return new Number(getRandom());
    }

    public static Number mock(int number) {
        return new Number(number);
    }

    public Number(int number) {
        this.number = number;
    }

    private static int getRandom() {
        return random.nextInt(44) + 1;
    }

    public int getNumber() {
        return number;
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

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}
