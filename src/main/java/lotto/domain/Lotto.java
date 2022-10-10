package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;
    private static final String LOTTO_SIZE_EXCEPTION = "로또번호는 6개여야 합니다.";

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION);
        }
        this.lottoNumbers = lottoNumbers;
    }
}
