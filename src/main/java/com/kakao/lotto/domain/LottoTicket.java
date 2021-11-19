package com.kakao.lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    protected final Set<LottoNumber> lottoNumbers;

    public static final int LOTTO_SIZE = 6;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validSizeNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        return new LottoTicket(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    private void validSizeNumber(Set<LottoNumber> lottoNumbers){
        if (lottoNumbers.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("입력된 로또 숫자 개수가 올바르지 않습니다");
        }
    }
}
