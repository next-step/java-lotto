package lotto.util;

import java.util.Random;

public class RandomUtil {

    private static final int BOUND = 45;
    private static final Random random = new Random();

    public static int getRandom() {
        return random.nextInt(BOUND) + 1;
    }
}
