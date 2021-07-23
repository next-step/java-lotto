package lotto.number;

import java.util.List;

public class LottoNumbers {
    public static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers from(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }
}
