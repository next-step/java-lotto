package lotto.domain;

import lotto.exception.InvalidLottoNumber;
import lotto.util.MessageContainer;

import java.util.Objects;
import java.util.Random;

public class RandomNumber implements Number {


    private final int number;


    public RandomNumber() {
        this(generateRandomNumber());
    }

    private static int generateRandomNumber() {
        return new Random().nextInt(MAX_NUMBER) + MIN_NUMBER ;
    }

    private RandomNumber(final int number) {
        isValid(number);
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!Number.class.isAssignableFrom(o.getClass())) return false;
        Number that = (Number) o;
        return number == that.number();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int compareTo(Number o) {
        return number - o.number();
    }

    @Override
    public int number() {
        return number;
    }
}
