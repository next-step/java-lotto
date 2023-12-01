package lotto.util;

import java.util.Random;

public class NumberUtil {
    private static final Random random = new Random();
    private static final int DIV_NUMBER = 1_000;

    private NumberUtil() {}

    public static Integer randomNum() {
        return random.nextInt(45) + 1;
    }

    public static int floorDiv(int money) {
        return Math.floorDiv(money, DIV_NUMBER);
    }


}
