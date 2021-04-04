package step3.domain.lotto;

import step3.exception.LottoSizeMissMatchException;

import java.util.Objects;
import java.util.Set;

public final class Lotto {

    public final static int PRICE = 1000;
    private final static int STANDARD_SIZE = 6;

    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        validateSize(lotto);
        this.lotto = lotto;
    }

    public static final Lotto of(Set<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

    private final void validateSize(Set<LottoNumber> lotto) {
        if (lotto.size() != STANDARD_SIZE) {
            throw new LottoSizeMissMatchException();
        }
    }

    public final boolean isInclude(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
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

}