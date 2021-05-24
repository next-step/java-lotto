package com.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class LottoAutoGenerator {
    private static final int LOTTO_NUMBER_TOTAL_COUNT = 6;
    private static final List<LottoNumber> range = new ArrayList<>();

    static {
        for (int i = LottoNumber.LOTTO_START_NUMBER; i <= LottoNumber.LOTTO_END_NUMBER; i++) {
            range.add(LottoNumber.valueOf(i));
        }
    }

    public static Lotto generate() {
        Collections.shuffle(range);
        TreeSet<LottoNumber> lottoNumbers = new TreeSet<>(range.subList(0, LOTTO_NUMBER_TOTAL_COUNT));

        return new Lotto(lottoNumbers);
    }
}
