package lotto.utile;

import java.util.Random;

public class RandomNumberGenerator {
    public static final Random random = new Random();
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 45;

    public static int getRandomNumber() {
        return random.nextInt(MAX_BOUND - MIN_BOUND) + 1;
    }
}
