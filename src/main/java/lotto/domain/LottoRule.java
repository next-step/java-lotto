package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRule {
    public static final int CHOICE_COUNT = 6;
    public static final int PRICE = 1000;
    public static final List<Integer> NUMBER_RANGE = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            NUMBER_RANGE.add(i);
        }
    }
}
