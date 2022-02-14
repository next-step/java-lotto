package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public static Lotto from(List<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

    public List<LottoNumber> getLotto() {
        return Collections.unmodifiableList(lotto);
    }
}
