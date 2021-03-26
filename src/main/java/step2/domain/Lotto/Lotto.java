package step2.domain.Lotto;

import step2.exception.ListNullPointerException;

import java.util.List;

public final class Lotto {
    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        if (isListNull(lotto)) {
            throw new ListNullPointerException();
        }
        this.lotto = lotto;
    }

    public static final Lotto newInstance(List<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

    private final boolean isListNull(List<LottoNumber> lotto) {
        return lotto == null;
    }


}
