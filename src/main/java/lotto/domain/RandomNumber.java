package lotto.domain;

import lotto.exception.InvalidLottoNumber;
import lotto.util.MessageContainer;

import java.util.Objects;
import java.util.Random;

public class RandomNumber implements Comparable<RandomNumber> {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;


    public RandomNumber() {
        this(generateRandomNumber());
    }

    private static int generateRandomNumber() {
        return new Random().nextInt(MAX_NUMBER) + MIN_NUMBER ;
    }

    public RandomNumber(final int number) {
        isValid(number);
        this.number = number;
    }

    private void isValid(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidLottoNumber(String.format("%s %d", MessageContainer.INVALID_LOTTO_NUMBER, number));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomNumber that = (RandomNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(RandomNumber o) {
        return number - o.number;
    }
}
