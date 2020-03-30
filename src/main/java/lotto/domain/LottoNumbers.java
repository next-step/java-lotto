package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int HAS_CONDITION = 1;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validate(lottoNumbers);
    }

    public LottoNumbers(LottoNumber... lottoNumbers) {
        this(Arrays.asList(lottoNumbers));
    }

    public boolean contains(int lottoNumber) {
        return lottoNumbers.stream()
                .filter(number -> number.equals(new LottoNumber(lottoNumber)))
                .count() == HAS_CONDITION;
    }

    public int size() {
        return lottoNumbers.size();
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoNumbersSizeException();
        }
    }
}
