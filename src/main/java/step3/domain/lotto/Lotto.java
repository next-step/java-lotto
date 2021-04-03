package step3.domain.lotto;

import java.util.Set;

public final class Lotto {

    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public static final Lotto of(Set<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

}