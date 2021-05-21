package com.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberCreator {
    private static final int LOTTO_NUMBER_TOTAL_COUNT = 6;
    private static final List<Integer> range = new ArrayList<>();

    static {
        for(int i=1; i<=45; i++) {
            range.add(i);
        }
    }

    public static List<Integer> create() {
        Collections.shuffle(range);
        return range.subList(0, LOTTO_NUMBER_TOTAL_COUNT);
    }
}
