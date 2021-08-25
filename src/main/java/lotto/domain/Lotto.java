package lotto.domain;

import lotto.exception.InputError;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_LENGTH = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new InputError("로또는 서로 다른 6개의 숫자여야 합니다.");
        }
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public static Lotto of(final List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers.stream()
                .map(LottoNumber::new)
                .distinct()
                .collect(Collectors.toList()));
    }

    public int countSameNumber(final Lotto otherLotto) {
        return (int) otherLotto.values().stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public List<Integer> convertIntegerList() {
        return lottoNumbers.stream()
                .map(LottoNumber::value)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> values() {
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
