package lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getCount() {
        return this.lottos.size();
    }
}
