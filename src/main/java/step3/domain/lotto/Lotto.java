package step3.domain.lotto;

import step3.exception.LottoSizeMissMatchException;

import java.util.Set;

public final class Lotto {
    private final int STANDARD_SIZE = 6;

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
}