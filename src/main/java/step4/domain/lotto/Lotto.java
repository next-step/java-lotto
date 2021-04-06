package step4.domain.lotto;

import step4.exception.LottoSizeMissMatchException;

import java.util.Set;

public final class Lotto {

    public static final int SIZE = 6;

    private final Set<LottoNumber> lotto;

    private Lotto(Set<LottoNumber> lotto) {
        validateSize(lotto);
        this.lotto = lotto;
    }

    public static final Lotto of(Set<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

    private final void validateSize(Set<LottoNumber> lotto) {
        if(lotto.size() != SIZE) {
            throw new LottoSizeMissMatchException();
        }
    }

    public final boolean isIncludeLottoNumber(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }
}
