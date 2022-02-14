package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String ERROR_LOTTO_NUMBER = "로또 번호는 6개여야 합니다.";

    private Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumber) {
        validate(lottoNumber);
        this.lottoNumbers = lottoNumber;
    }

    private void validate(Set<LottoNumber> lottoNumber) {
        if (lottoNumber.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER);
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

}
