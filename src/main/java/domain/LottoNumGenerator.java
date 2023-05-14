package domain;

import java.util.*;

public class LottoNumGenerator {
    private static final int LOTTO_NUM_LIMIT = 45;
    private static final int LOTTO_SIZE = 6;

    private static final List<Integer> LOTTO_BALLS = new ArrayList<>();

    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>();

    static {
        for (int i = 1; i <= LOTTO_NUM_LIMIT; i++) {
            LOTTO_BALLS.add(i);
        }

        for (int i = 1; i <= LOTTO_NUM_LIMIT; i++) {
            LOTTO_NUMBER_MAP.put(i, new LottoNumber(i));
        }
    }

    public static int[] generateNumbers() {
        int[] generatedNumbers = new int[LOTTO_SIZE];
        Collections.shuffle(LOTTO_BALLS);
        Collections.shuffle();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            generatedNumbers[i] = LOTTO_BALLS.get(i);
        }
        Arrays.sort(generatedNumbers);

        return generatedNumbers;
    }

    public static List<LottoNumber> generateNumbers2() {
        List<LottoNumber> generatedNumbers = new ArrayList<>();
        Collections.shuffle(LOTTO_BALLS);
        for (int i = 0; i < LOTTO_SIZE; i++) {
            generatedNumbers[i] = LOTTO_BALLS.get(i);
        }
        Arrays.sort(generatedNumbers);

        return generatedNumbers;
    }
}
