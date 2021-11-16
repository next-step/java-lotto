package com.kakao.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    protected final List<LottoNumber> lottoNumbers;

    public static final int LOTTO_SIZE = 6;

    public LottoTicket(List<LottoNumber> inputNumbers) {
        List<LottoNumber> lottoNumbers = inputNumbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        validSizeNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private void validSizeNumber(List<LottoNumber> lottoNumbers){
        if (lottoNumbers.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("입력된 로또 숫자 개수가 올바르지 않습니다");
        }
    }
}
