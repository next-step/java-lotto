package util;

import java.util.HashSet;
import java.util.Set;

public class Random {
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_MAX_VALUE = 45;
    private static final int INITIALIZATION_RANDOM_NUMBER = 1;


    public static Set<Integer> generationRandom() {
        Set<Integer> random = new HashSet<>();

        for (int i = 0; i < LOTTO_LENGTH; i++) {
            random.add((int)(Math.random() * LOTTO_MAX_VALUE) + INITIALIZATION_RANDOM_NUMBER);
        }

        return random;
    }
}
