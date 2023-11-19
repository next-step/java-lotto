package lotto.util;

import java.util.Random;

public class Util {
    private static final String SEPARATOR = ", ";
    private static final Random random = new Random();

    public static Integer randomNum() {
        return random.nextInt(45) + 1;
    }

    public static String[] split(String str) {
        return str.split(SEPARATOR);
    }

    public static int floorDiv(int money) {
        return Math.floorDiv(money, 1000);
    }
}
