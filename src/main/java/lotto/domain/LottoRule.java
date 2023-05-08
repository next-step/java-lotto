package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRule {
    public static final int CHOICE_COUNT = 6;
    public static final List<Integer> NUMBER_RANGE;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;

    static {
        NUMBER_RANGE = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            NUMBER_RANGE.add(i);
        }
    }
}
