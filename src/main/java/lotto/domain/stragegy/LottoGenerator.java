package lotto.domain.stragegy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_HAVE_NUMBER_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER_SIZE = 1;
    private static final int LOTTO_MAX_NUMBER_SIZE = 45;

    public static List<Integer> lottoNumberGenerator() {
        List<Integer> pool = new ArrayList<>();

        pool = makeLottoPool();
        pool.subList(0, LOTTO_HAVE_NUMBER_SIZE);
        Collections.sort(pool);

        return pool;
    }

    private static List<Integer> makeLottoPool() {
        List<Integer> pool = new ArrayList<>();

        for (int i = LOTTO_MIN_NUMBER_SIZE; i <= LOTTO_MAX_NUMBER_SIZE; i++) {
            pool.add(i);
        }
        Collections.shuffle(pool);

        return pool;
    }
}
