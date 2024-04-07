package domain;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {

    private final List<Lotto> lottos;

    public MyLotto() {
        this.lottos = new ArrayList<>();
    }

    public void add(List<LottoBall> nowLotto) {
        this.lottos.add(new Lotto(nowLotto));
    }

    public List<Lotto> getLotto() {
        return lottos;
    }
}

