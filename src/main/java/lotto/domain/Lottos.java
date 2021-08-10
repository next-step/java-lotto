package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 65;
    private static final int LOTTO_FROM_INDEX = 0;
    private static final int LOTTO_TO_INDEX = 6;
    private static final List<Integer> ASCENDING_SORTED_LOTTO_NUMBERS = new ArrayList<>();
    private static final List<Integer> SHUFFLING_LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            ASCENDING_SORTED_LOTTO_NUMBERS.add(i);
            SHUFFLING_LOTTO_NUMBERS.add(i);
        }
    }

    public List<Integer> getLotteryNumbers() {
        return SHUFFLING_LOTTO_NUMBERS.subList(LOTTO_FROM_INDEX, LOTTO_TO_INDEX);
    }

    public Lottos shuffle() {
        Collections.shuffle(SHUFFLING_LOTTO_NUMBERS);
        return this;
    }
}
