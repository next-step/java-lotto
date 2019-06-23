package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();
    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 49;
    private static final Integer LOTTO_NUMBER_SIZE = 6;

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public static List<Integer> create() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_SIZE);
    }
}
