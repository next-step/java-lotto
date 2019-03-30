package util;

import lotto.domain.LotteryNo;

import java.util.*;

public class Random {
    private static final int LOTTO_MAX_VALUE = 45;


    public static Set<LotteryNo> generateRandom() {
        List<LotteryNo> random = makeNumber();

        Collections.shuffle(random);

        return new HashSet<>(random.subList(0, 6));
    }

    public static List<LotteryNo> makeNumber() {
        List<LotteryNo> random = new ArrayList<>();

        for (int i = 1; i < LOTTO_MAX_VALUE + 1; i++) {
            random.add(new LotteryNo(i));
        }

        return random;
    }
}
