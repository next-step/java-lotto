package lotto;

import java.util.Random;

public class LottoRandomGenerator {
    private static final int MAX_NUMBER_OF_LOTTO = 45;
    private final Random random;

    public LottoRandomGenerator() {
        this.random = new Random();
    }

    public LottoRandomGenerator(long seed) {
        this.random = new Random(seed);
    }

    public int pick() {
        return this.random.nextInt(MAX_NUMBER_OF_LOTTO) + 1;
    }
}
