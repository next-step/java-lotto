package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class Lotto {
    private final static int LOTTO_NUMBERS_SIZE = 6;
    private final static String ERROR_LOTTO_NUMBER = "로또 번호는 6개여야 합니다.";
    private Set<LottoNumber> lottoNumber;

    public Lotto(Set<LottoNumber> lottoNumber) {
        if(lottoNumber.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER);
        }
        this.lottoNumber = lottoNumber;
    }

    public Set<LottoNumber> getLottoNumber() {
        return Collections.unmodifiableSet(lottoNumber);
    }

}
