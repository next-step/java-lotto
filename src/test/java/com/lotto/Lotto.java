package com.lotto;

import java.util.List;

public final class Lotto {

    public static final int UNIT_PRICE = 1000;

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}
