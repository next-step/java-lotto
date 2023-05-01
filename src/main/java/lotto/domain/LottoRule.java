package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRule {
    public static final int CHOICE_COUNT = 6;
    public static final int PRICE = 1000;
    public static final List<Integer> NUMBER_RANGE;
    public static final int MATCHED_3_NUMBERS_PRIZE = 5000;
    public static final int MATCHED_4_NUMBERS_PRIZE = 50000;
    public static final int MATCHED_5_NUMBERS_PRIZE = 1500000;
    public static final int MATCHED_6_NUMBERS_PRIZE = 2000000000;

    static {
        NUMBER_RANGE = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            NUMBER_RANGE.add(i);
        }
    }
}
