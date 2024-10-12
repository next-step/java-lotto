package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private static final String SIZE_ERROR = "로또는 " + LOTTO_SIZE + "개의 번호여야 합니다.";

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final Set<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }
}
