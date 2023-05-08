package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumGenerator {
    private static final int LOTTO_NUM_LIMIT = 45;
    private static final int LOTTO_SIZE = 6;

    private static final List<Integer> LOTTO_BALLS = new ArrayList<>();

    static {
        for (int i = 1; i <= LOTTO_NUM_LIMIT; i++) {
            LOTTO_BALLS.add(i);
        }

    }

    public static int[] generateNumbers() {
        int[] generatedNumbers = new int[LOTTO_SIZE];
        Collections.shuffle(LOTTO_BALLS);
        for (int i = 0; i < LOTTO_SIZE; i++) {
            generatedNumbers[i] = LOTTO_BALLS.get(i);
        }
        Arrays.sort(generatedNumbers);

        return generatedNumbers;
    }
}
