package util;

import java.util.*;

public class Random {
    private static final int LOTTO_MAX_VALUE = 45;


    public static Set<Integer> generationRandom() {
        List<Integer> random = makeNumber();

        Collections.shuffle(random);

        return new HashSet<>(random.subList(0, 6));
    }

    public static List<Integer> makeNumber() {
        List<Integer> random = new ArrayList<>();

        for (int i = 1; i < LOTTO_MAX_VALUE + 1; i++) {
            random.add(i);
        }

        return random;
    }
}
