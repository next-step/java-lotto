package lotto.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoGenerator {

    private static final int LOTTO_SIZE_BOUND = 6;
    private static final int LOTTO_MAXIMUM_BOUND = 45;
    private final Random RANDOM;

    public LottoGenerator() {
        this.RANDOM = new Random();
    }

    public Set<Integer> generateLotto() {
        Set<Integer> lotto = new HashSet<>();
        while (lotto.size() != LOTTO_SIZE_BOUND) {
            lotto.add(generate());
        }
        return lotto;
    }

    private Integer generate() {
        return RANDOM.nextInt(LOTTO_MAXIMUM_BOUND) + 1;
    }
}
