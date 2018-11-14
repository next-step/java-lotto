package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LotteryNumberGenerator {

    public static Set<Integer> generate() {
        return new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
