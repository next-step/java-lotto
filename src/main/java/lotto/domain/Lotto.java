package lotto.domain;

import lotto.exception.LottoApplicationException;

import java.util.Objects;

public class Lotto {

    public static final int LOTTO_NUMBERS_COUNT = 6;

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new LottoApplicationException("로또 숫자는 6개여야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
