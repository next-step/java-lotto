package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> lotto;
    public Lotto(List<Integer> lottoGame) {
        this.lotto = lottoGame;
    }

    public int size() {
        return lotto.size();
    }

    public List<Integer> getValue() {
        return Collections.unmodifiableList(lotto);
    }
}
