package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberPool {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public static List<Integer> makePool() {
        List<Integer> pool = new ArrayList<>();

        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            pool.add(i);
        }

        return pool;
    }
}
