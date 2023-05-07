package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRule {
    public static final int CHOICE_COUNT = 6;
    public static final List<Integer> NUMBER_RANGE;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;
    public static final int RANK_FIRST_PRIZE = 2000000000;
    public static final int RANK_SECOND_PRIZE = 1500000;
    public static final int RANK_THIRD_PRIZE = 50000;
    public static final int RANK_FOURTH_PRIZE = 5000;
    public static final int MATCH_COUNT_FOR_RANK_FIRST = 6;
    public static final int MATCH_COUNT_FOR_RANK_SECOND = 5;
    public static final int MATCH_COUNT_FOR_RANK_THIRD = 4;
    public static final int MATCH_COUNT_FOR_RANK_FOURTH = 3;

    static {
        NUMBER_RANGE = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            NUMBER_RANGE.add(i);
        }
    }
}
