package game.lotto.util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    public static int generateStartWithOne(int bound) {

        return generateStartWithZero(bound) + 1;
    }

    public static int generateStartWithZero(int bound) {

        return random.nextInt(bound);
    }

}
