package lotto.util;

import java.util.Random;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class RandomUtils {

    private final static Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static Integer getNumber(int limit) {
        return RANDOM.nextInt(limit) + 1;
    }
}
