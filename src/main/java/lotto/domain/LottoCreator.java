package lotto.domain;

import java.util.ArrayList;
import java.util.List;


public class LottoCreator {
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    public static final int FIRST_NUMBERS = 1;
    public static final int LAST_NUMBERS = 45;

    static {
        for (int i = FIRST_NUMBERS; i < LAST_NUMBERS; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }
}
