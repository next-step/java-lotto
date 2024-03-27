package domain;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {

    private final List<Lotto> lotto;

    public MyLotto() {
        this.lotto = new ArrayList<>();
    }

    public void add(List<Integer> nowLotto) {
        this.lotto.add(new Lotto(nowLotto));
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}

