package com.lotto.domain;

import java.util.TreeSet;

public final class Lotto {

    public static final int UNIT_PRICE = 1000;
    public static final int LOTTO_COUNT = 6;

    private TreeSet<LottoNumber> lottoNumbers;

    public Lotto(TreeSet<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public TreeSet<LottoNumber> numbers() {
        return lottoNumbers;
    }
}
