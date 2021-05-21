package lotto.shop;

import java.util.Random;

public class NumberGenerator {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private final static Random random = new Random();

    public static int generate() {
        return random.nextInt(MAX_NUM) + MIN_NUM;
    }
}
