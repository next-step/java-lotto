package lotto.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringToLottoNumbers {
    private final LottoNumbers lottoNumbers;

    private StringToLottoNumbers(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers lottoNumbers(){
        return this.lottoNumbers;
    }

    public static StringToLottoNumbers of(String input) {
        LottoNumbers lottoNumbers = new LottoNumbers(
                Arrays.stream(input.split(", "))
                        .map(stringElement -> new StringToInteger(stringElement).number())
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet()));
        return new StringToLottoNumbers(lottoNumbers);
    }
}
