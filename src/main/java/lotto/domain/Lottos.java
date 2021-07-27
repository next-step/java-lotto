package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public int getSize() {
        return lottos.size();
    }
}
