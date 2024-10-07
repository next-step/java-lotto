package step2.util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static int randomNum() {
        return random.nextInt(45) + 1;
    }
}
