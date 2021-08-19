package lotto.domain;

import lotto.exception.InputError;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int LOTTO_LENGTH = 6;

    private final List<Integer> lottoNumbers;

    public Lotto(final List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new InputError("로또는 6개의 숫자여야 합니다.");
        }
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public int countSameNumber(final Lotto otherLotto) {
        return (int) otherLotto.value().stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public List<Integer> value() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
