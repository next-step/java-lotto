package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> numbers() {
        return lotto;
    }

    public int getSize() {
        return lotto.size();
    }
}
