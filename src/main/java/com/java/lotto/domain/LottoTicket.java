package com.java.lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public String lottoNumbersToString() {
        return lottoNumbers.toString();
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }


}
