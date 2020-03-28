package step2;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = new ArrayList<>(lotto);
    }
}
