package lotto.utility;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    private RandomNumberGenerator() {
    }

    public static int generateRandomNumber() {
        return random.nextInt(45) + 1;
    }
}
