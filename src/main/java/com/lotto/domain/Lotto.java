package com.lotto.domain;

import java.util.List;

public class Lotto {

    private List<Integer> extractedLottoNumbers;

    public Lotto(List<Integer> extractedLottoNumbers) {
        this.extractedLottoNumbers = extractedLottoNumbers;
    }

    @Override
    public String toString() {
        return this.extractedLottoNumbers.toString();
    }
}
