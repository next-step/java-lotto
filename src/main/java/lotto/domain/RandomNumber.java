package lotto.domain;

import lotto.exception.InvalidLottoNumber;

import java.util.Random;

public class RandomNumber {
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
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidLottoNumber(String.format("invalid lotto number %d", number));
        }
        this.number = number;
    }
}
