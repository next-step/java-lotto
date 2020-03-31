package lotto.domain.stragegy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberAutoGenerator {
    private static final int LOTTO_HAVE_NUMBER_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER_SIZE = 1;
    private static final int LOTTO_MAX_NUMBER_SIZE = 45;
    private static final List<Integer> LOTTO_NUMBER_POOL;

    static {
        List<Integer> pool = new ArrayList<>();

        for (int i = LOTTO_MIN_NUMBER_SIZE; i <= LOTTO_MAX_NUMBER_SIZE; i++) {
            pool.add(i);
        }
        LOTTO_NUMBER_POOL = Collections.unmodifiableList(pool);
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> pool = new ArrayList<>(LOTTO_NUMBER_POOL);
        Collections.shuffle(pool);
        pool = pool.subList(0, LOTTO_HAVE_NUMBER_SIZE);
        Collections.sort(pool);

        return pool;
    }
}
