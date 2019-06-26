package com.java.lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers(){
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int lottoNumbersCount(){
        return lottoNumbers.size();
    }
}
