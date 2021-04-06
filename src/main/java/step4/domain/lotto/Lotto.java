package step4.domain.lotto;

import java.util.Set;

public final class Lotto {

    private final Set<LottoNumber> lotto;

    private Lotto(Set<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public static final Lotto of(Set<LottoNumber> lotto) {
        return new Lotto(lotto);
    }
}
