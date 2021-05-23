package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lotto getLotto(int index) {
        return this.lottos.get(index);
    }

    public int getCountOfLottos() {
        return this.lottos.size();
    }
}
