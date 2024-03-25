package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {

    public static final int PRICE = 1_000;

    private final LottoNumbers lottoNumbers;
    private final List<LottoNumber> lottoNumbers1;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

        this.lottoNumbers1 = new ArrayList<>();
    }

    public Rank rank(WinningLotto winningLotto) {
        return winningLotto.rank(this.lottoNumbers);
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
