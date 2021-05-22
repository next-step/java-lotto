package com.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumberGenerator {
    private static final int LOTTO_NUMBER_TOTAL_COUNT = 6;
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    private static final List<Integer> range = new ArrayList<>();

    static {
        for(int i=LOTTO_START_NUM; i<=LOTTO_END_NUM; i++) {
            range.add(i);
        }
    }

    public static List<Integer> generate() {
        Collections.shuffle(range);
        List<Integer> lottoNumbers = range.subList(0, LOTTO_NUMBER_TOTAL_COUNT);
        lottoNumbers.sort(Comparator.naturalOrder());

        return lottoNumbers;
    }
}
