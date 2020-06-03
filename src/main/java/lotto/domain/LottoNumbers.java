package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    private final Set<Integer> lottoNumberSet;

    public LottoNumbers(Set<Integer> lottoNumberSet) {
        this.lottoNumberSet = lottoNumberSet;
    }

    public Set<Integer> getLottoNumberSet() {
        return lottoNumberSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumberSet, that.lottoNumberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberSet);
    }
}
