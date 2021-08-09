package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public int size() {
        return lottos.size();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }
}
