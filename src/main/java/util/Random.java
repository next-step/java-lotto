package util;

import java.util.*;

public class Random {
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_MAX_VALUE = 45;
    private static final int INITIALIZATION_RANDOM_NUMBER = 1;


    public static Set<Integer> generationRandom() {
        List<Integer> random = new ArrayList<>();

        for (int i = 0; i < LOTTO_MAX_VALUE; i++) {
            random.add(i);
        }

        Collections.shuffle(random);

        return new HashSet<>(random.subList(0, 6));
    }
}
