package lotto.util;

import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();
    private static final int MAX_BOUNDARY = 45;


    public static int getRandomNumber() {
        return RANDOM.nextInt(MAX_BOUNDARY);
    }
}
