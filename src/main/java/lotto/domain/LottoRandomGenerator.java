package lotto.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoRandomGenerator {
    private static final int MAX_NUMBER_OF_LOTTO = 45;
    private final Random random;

    public LottoRandomGenerator() {
        this(new Random());
    }

    public LottoRandomGenerator(long seed) {
        this(new Random(seed));
    }

    public LottoRandomGenerator(Random random) {
        this.random = random;
    }

    public int pick() {
        return this.random.nextInt(MAX_NUMBER_OF_LOTTO) + 1;
    }

    public Set<Integer> generate(int totalSize) {
        Set<Integer> result = new HashSet<>();
        while (result.size() < totalSize) {
            result.add(pick());
        }
        return result;
    }
}
