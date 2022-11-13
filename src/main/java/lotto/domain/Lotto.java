package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }


}
