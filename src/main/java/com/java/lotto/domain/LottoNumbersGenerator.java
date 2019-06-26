package com.java.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static List<Integer> automaticNumbersGenerator() {
        List<Integer> LottoNumberRange = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            LottoNumberRange.add(i);
        }
        return shuffle(LottoNumberRange);
    }

    private static List<Integer> shuffle(List<Integer> LottoNumberRange) {
        Collections.shuffle(LottoNumberRange);
        return sort(LottoNumberRange.subList(0, 6));
    }

    private static List<Integer> sort(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
