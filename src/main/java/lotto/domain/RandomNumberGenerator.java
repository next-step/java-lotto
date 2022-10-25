package lotto.domain;

import java.util.Random;

public class RandomNumberGenerator {

    private final Random random;
    private final int lowBound;
    private final int upperBound;

    public RandomNumberGenerator(int lowBound, int upperBound) {
        this.random = new Random();
        this.lowBound = lowBound;
        this.upperBound = upperBound;
    }

    public int generate() {
        return random.nextInt(upperBound + 1) + lowBound;
    }
}
