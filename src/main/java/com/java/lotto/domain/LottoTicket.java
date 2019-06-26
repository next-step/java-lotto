package com.java.lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public String getLottoNumbers(){
        return lottoNumbers.toString();
    }
}
