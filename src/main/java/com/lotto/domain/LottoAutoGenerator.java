package com.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoAutoGenerator {
    private static final int LOTTO_NUMBER_TOTAL_COUNT = 6;
    private static final List<LottoNumber> range = new ArrayList<>();

    static {
        for (int i = LottoNumber.LOTTO_START_NUMBER; i <= LottoNumber.LOTTO_END_NUMBER; i++) {
            range.add(new LottoNumber(i));
        }
    }

    public static Lotto generate() {
        Collections.shuffle(range);
        List<LottoNumber> lottoNumbers = range.subList(0, LOTTO_NUMBER_TOTAL_COUNT);
        lottoNumbers.sort(Comparator.naturalOrder());

        return new Lotto(lottoNumbers);
    }
}
