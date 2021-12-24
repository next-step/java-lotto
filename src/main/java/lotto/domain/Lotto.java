package lotto.domain;

import lotto.domain.stat.LottoRank;

import java.util.List;
import java.util.Objects;

public class Lotto {

    public static final int LOTTO_NUMBERS_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoRank calculateRank(Lotto winningLotto) {
        int matchedNumberCount  = (int) lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();

        return LottoRank.of(matchedNumberCount);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
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
