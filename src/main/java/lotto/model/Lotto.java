package lotto.model;

import java.util.List;

public class Lotto {
    List<Integer> lotto;
    public Lotto() {
        this.lotto = new LottoNumber().pickLotto();
    }

    public List<Integer> getLottoNumber() {
        return lotto;
    }
}
