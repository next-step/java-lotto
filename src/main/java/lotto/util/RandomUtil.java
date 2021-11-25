package lotto.util;

import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();

    public static int randomInt(int bound) {
        return RANDOM.nextInt(bound) + 1;
    }
}
