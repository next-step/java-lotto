package step2.domain.Lotto;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public static Lotto newInstance(List<LottoNumber> lotto) {
        return new Lotto(lotto);
    }


}
