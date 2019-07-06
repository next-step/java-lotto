package com.java.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LottoTicket {
    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
    
    public Stream<Integer> numbersStream(){
    	return lottoNumbers.stream();
    }
    
	public boolean isMatchNumber(Integer number) {
		return lottoNumbers.contains(number);
	}
}
