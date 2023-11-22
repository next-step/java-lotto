package com.fineroot.lotto.dto;

import com.fineroot.lotto.domain.LottoNumber;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {
    private final List<LottoNumber> lottoNumbers;

    private WinningNumber(List<LottoNumber> numbers) {
        this.lottoNumbers = numbers;
    }

    public static WinningNumber from(String numbers) {
        return new WinningNumber(
                Arrays.stream(numbers.split(","))
                        .map(e -> LottoNumber.from(Integer.parseInt(e.trim())))
                        .collect(Collectors.toList()));
    }

    public static WinningNumber defaultCreate() {
        return new WinningNumber(
                Stream.of(1, 1, 1, 1, 1, 1)
                        .map(LottoNumber::from)
                        .collect(Collectors.toList()));
    }

    public boolean contains(LottoNumber lottoNumber){
        return lottoNumbers.contains(lottoNumber);
    }
}
