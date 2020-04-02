package lotto2.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private static int MAX_LOTTO_COUNT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = validate(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return new HashSet<>(lottoNumbers);
    }

    private Set<LottoNumber> validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("중복 없이 숫자를 6개 입력해주세요.");
        }
        return new HashSet<>(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(getLottoNumbers(), lotto.getLottoNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers());
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
