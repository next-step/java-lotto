package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> lotto;

    private Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto from(List<Integer> lotto) {
        return new Lotto(lotto);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }
}
