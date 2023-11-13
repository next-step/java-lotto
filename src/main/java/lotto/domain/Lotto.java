package lotto.domain;

import lotto.strategy.LottoGenerator;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(LottoGenerator lottoGenerator) {
        this.lottoNumbers = new LottoNumbers(lottoGenerator);
    }

    public long matchCount(List<Integer> winLottoNumbers) {
        return lottoNumbers.matchCount(winLottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
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
