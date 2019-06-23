package step2;

import java.util.ArrayList;
import java.util.List;

public abstract class LottoGenerator {
    public static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();
    public static final Integer LOTTO_MIN_NUMBER = 1;
    public static final Integer LOTTO_MAX_NUMBER = 49;
    public static final Integer LOTTO_NUMBER_SIZE = 6;

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public abstract Lotto generate();
}
