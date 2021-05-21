package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public int count() {
        return lottos.size();
    }

    public void buy() {
        lottos.add(new Lotto());
    }
}
