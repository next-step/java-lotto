package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    public static final int CORRECT_LOTTO_NUMBERS_SIZE = 6;
    private static final String NOT_CORRECT_LOTTO_NUMBERS_MESSAGE = "로또번호는 총 6개여야 합니다.";

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
        validateLottoNumbers(lottoNumbers);
    }

    private void validateLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != CORRECT_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NOT_CORRECT_LOTTO_NUMBERS_MESSAGE);
        }
    }

    public boolean contain(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return new HashSet<>(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }
}
