package lotto.domain;

import java.util.Objects;

public class Lottery {

    private LottoNumbers lottoNumbers;

    public Lottery(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Lottery lottery = (Lottery) o;
        return Objects.equals(lottoNumbers, lottery.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
