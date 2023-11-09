package lotto.strategy;

import java.util.Random;

public class RandomNumberStrategy implements NumberStrategy {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Random RANDOM = new Random();

    @Override
    public int create() {
        return RANDOM.nextInt(MAX_NUMBER) + MIN_NUMBER;
    }
}
