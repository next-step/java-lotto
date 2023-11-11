package lotto.step2.util;

import java.util.*;

public class LottoNumberGenerator {
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public static Set<Integer> generateLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);

        return new TreeSet<>(LOTTO_NUMBERS.subList(0, 6));
    }
}
