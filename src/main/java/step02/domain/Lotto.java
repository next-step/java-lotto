package step02.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public static Lotto of(List<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    public int matchCount(Lotto winningNumbers) {
        int total = 0;
        for(LottoNumber lottoNumber : lotto) {
            if (winningNumbers.lotto.contains(lottoNumber)) {
                total += 1;
            }
        }
        return total;
    }

    public List<LottoNumber> print() {
        return lotto;
    }
}
