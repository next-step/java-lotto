package autolotto.domain;

import java.util.*;

public class LottoGenerator {
    private static final Random RANDOM = new Random();
    private static final int LOTTO_SIZE = 6;
    private static final int RANDOM_BOUND = 45;
    private static final int LOTTO_START_NUMBER = 1;

    public Set<Integer> generate() {
        Set<Integer> lotto = new HashSet<>(LOTTO_SIZE);
        do {
            lotto.add(getRandom());
        } while (lotto.size() < LOTTO_SIZE);
        return lotto;
    }

    private int getRandom() {
        return RANDOM.nextInt(RANDOM_BOUND) + LOTTO_START_NUMBER;
    }
}
