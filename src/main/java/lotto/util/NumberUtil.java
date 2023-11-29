package lotto.util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NumberUtil {
    private static final Random random = new Random();

    private NumberUtil() {
    }

    public static Integer randomNum() {
        return random.nextInt(45) + 1;
    }

    public static int floorDiv(int money) {
        return Math.floorDiv(money, 1000);
    }


}
