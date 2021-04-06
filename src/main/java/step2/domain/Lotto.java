package step2.domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean isContains(LottoNumber compareLottoNumber) {
        return lottoNumbers.stream()
                .anyMatch(compareLottoNumber::equals);
    }

    public int matchNumberCounts (Lotto compareLotto) {
        long count = this.lottoNumbers.stream()
                .filter(compareLotto::isContains)
                .count();

        return (int)count;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;

        Lotto lotto = (Lotto) o;

        return lottoNumbers != null ? lottoNumbers.equals(lotto.lottoNumbers) : lotto.lottoNumbers == null;
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }
}
