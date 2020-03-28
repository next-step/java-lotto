package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottery {

    private List<LottoNumber> lottoNumbers;

    public Lottery(final List<LottoNumber> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
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
